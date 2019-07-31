package com.delvo.commerce;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter {
private List<CartItemModel> cartItemModelList;

    public CartAdaptor(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
       switch (cartItemModelList.get(position).getType()){
           case 0:
               return CartItemModel.CART_ITEM;
           case 1:
               return CartItemModel.TOTAL_AMOUNT;
               default:
                   return -1;
       }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case CartItemModel.CART_ITEM:
                View cartItemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                return new cartItemViewHolder(cartItemView);

            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                return new cartTotalAmountViewHolder(cartTotalView);
                default:return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (cartItemModelList.get(position).getType()){
            case CartItemModel.CART_ITEM:
                int resource=cartItemModelList.get(position).getProductImage();
                String title=cartItemModelList.get(position).getProductTitle();
                int freeCoupons=cartItemModelList.get(position).getFreeCoupons();
                String productPrice=cartItemModelList.get(position).getProductPrice();
                String cuttedPrice=cartItemModelList.get(position).getCuttedPrice();
                int offersApplied=cartItemModelList.get(position).getOffersApplied();
                ((cartItemViewHolder)viewHolder).setItemDetails(resource,title,freeCoupons,productPrice,cuttedPrice,offersApplied);

                break;
                case CartItemModel.TOTAL_AMOUNT:
                  String totalItems=cartItemModelList.get(position).getTotalItems();
                    String totalItemsPrice=cartItemModelList.get(position).getTotalItemPrice();
                    String deliveryPrice=cartItemModelList.get(position).getDeliveryPrice();
                    String totalAmount=cartItemModelList.get(position).getTotalAmount();
                    String savedAmount=cartItemModelList.get(position).getSavedAmount();
                    ((cartTotalAmountViewHolder)viewHolder).setTotalAmount(totalItems,totalItemsPrice,deliveryPrice,totalAmount,savedAmount);
                    break;
                    default:return;
        }

    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }
    class cartItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupons;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView couponsApplied;
        private TextView productQuanity;
        private ImageView freeCouponIcon;




        public cartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage =itemView.findViewById(R.id.product_image);
            productPrice=itemView.findViewById(R.id.product_price);
            freeCoupons=itemView.findViewById(R.id.tv_free_coupon);
            freeCouponIcon=itemView.findViewById(R.id.free_coupon_icon);
            productTitle=itemView.findViewById(R.id.product_title);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            offersApplied=itemView.findViewById(R.id.offers_applied);
            couponsApplied=itemView.findViewById(R.id.payment_method);
            productQuanity=itemView.findViewById(R.id.product_quanity);

        }
        private void setItemDetails(int resource,String title,int freeCouponsNo,String productPriceText,String cuttedPriceText,int offersAppliedNo){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCouponsNo >0){
                freeCouponIcon.setVisibility(View.VISIBLE);
                freeCoupons.setVisibility(View.VISIBLE);
                if (freeCouponsNo==1){
                    freeCoupons.setText("free "+freeCouponsNo+" Coupon");
                }
                else {
                    freeCoupons.setText("free "+freeCouponsNo+" Coupons");
                }


            }else {
                freeCouponIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            if (offersAppliedNo>0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersAppliedNo+" Offers Applied");
            }else {
                offersApplied.setVisibility(View.INVISIBLE);
            }

        }
    }
    class cartTotalAmountViewHolder extends RecyclerView.ViewHolder{
        private TextView totalItems;
        private TextView totalItemsPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView savedAmount;

        public cartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItems=itemView.findViewById(R.id.total_items);
            totalItemsPrice=itemView.findViewById(R.id.total_item_price);
            deliveryPrice=itemView.findViewById(R.id.delivery_price);
            totalAmount=itemView.findViewById(R.id.total_price);
            savedAmount=itemView.findViewById(R.id.saved_amount);

        }
        private void setTotalAmount(String totalItemsText,String totalItemsPriceText,String deliveryPriceText,String totalAmountText,String savedAmountText){
            totalItems.setText(totalItemsText);
            totalItemsPrice.setText(totalItemsPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedAmountText);


        }
    }
}

