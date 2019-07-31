package com.delvo.commerce;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WishListAdaptor extends RecyclerView.Adapter<WishListAdaptor.ViewHolder> {
    List<WishListModel> wishListModelList;

    public WishListAdaptor(List<WishListModel> wishListModelList) {
        this.wishListModelList = wishListModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
     int resource =wishListModelList.get(position).getProductImage();
        int freeCoupons =wishListModelList.get(position).getFreeCoupons();
        String title =wishListModelList.get(position).getProductTitle();
        String ratings =wishListModelList.get(position).getRating();
        int totalRatings =wishListModelList.get(position).getTotalRatings();
        String productPrice =wishListModelList.get(position).getProductPrice();
        String cuttedPrice =wishListModelList.get(position).getCuttedPrice();
        String paymentMethod =wishListModelList.get(position).getPaymentMethod();
        viewHolder.setData(resource,title,freeCoupons,ratings,totalRatings,productPrice,cuttedPrice,paymentMethod);




    }

    @Override
    public int getItemCount() {
        return wishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupons;
        private ImageView couponIcon;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private TextView rating;
        private  TextView totalRatings;
        private View priceCut;
        private ImageButton deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freeCoupons=itemView.findViewById(R.id.tv_free_coupon);
            couponIcon=itemView.findViewById(R.id.free_coupon_icon);
            productPrice=itemView.findViewById(R.id.product_price);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            paymentMethod=itemView.findViewById(R.id.payment_method);
            rating=itemView.findViewById(R.id.tv_product_rating_miniview);
            totalRatings=itemView.findViewById(R.id.total_ratings_miniview);
            priceCut=itemView.findViewById(R.id.price_cut);
            deleteBtn=itemView.findViewById(R.id.delete_button);

        }
        private void setData(int resource, String title, int freeCouponsNo, String avarageRate, int totalRatingsNo, String price, String cuttedPriceValue, String payMethod){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCouponsNo !=0){
                couponIcon.setVisibility(View.VISIBLE);
                if (freeCouponsNo==1) {
                    freeCoupons.setText("Free " + freeCouponsNo + " Coupon ");
                }else {
                    freeCoupons.setText("Free " + freeCouponsNo + " Coupons ");
                }
            }else {
                freeCoupons.setVisibility(View.INVISIBLE);
                couponIcon.setVisibility(View.INVISIBLE);
            }
            rating.setText(avarageRate);
            totalRatings.setText(totalRatingsNo+ " (Ratings)");
            productPrice.setText("Rs."+price+"/-");
            cuttedPrice.setText("Rs."+cuttedPriceValue+" /-");
            paymentMethod.setText(payMethod);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"Delete",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
