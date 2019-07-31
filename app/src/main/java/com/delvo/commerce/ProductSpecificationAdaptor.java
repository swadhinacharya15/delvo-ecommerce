package com.delvo.commerce;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ProductSpecificationAdaptor extends RecyclerView.Adapter<ProductSpecificationAdaptor.ViewHolder> {
    private List<ProductSpecificationModel> productSpecificationModelList;

    public ProductSpecificationAdaptor(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (productSpecificationModelList.get(position).getType()){
            case 0:
                return ProductSpecificationModel.specificationTitle;
            case 1:
                return ProductSpecificationModel.specificationBody;
                default:return -1;
        }
    }

    @NonNull
    @Override
    public ProductSpecificationAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case ProductSpecificationModel.specificationTitle:
                TextView title=new TextView(viewGroup.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(setDp(16,viewGroup.getContext()),
                        setDp(16,viewGroup.getContext()),
                        setDp(16,viewGroup.getContext()),
                        setDp(8,viewGroup.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);
                case ProductSpecificationModel.specificationBody:
                    View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_specification_item_layout,viewGroup,false);
                    return new ViewHolder(view);
                    default:return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationAdaptor.ViewHolder viewHolder, int position) {

        switch (productSpecificationModelList.get(position).getType()){
            case ProductSpecificationModel.specificationTitle:
                viewHolder.setTitle(productSpecificationModelList.get(position).getTitle());
                break;

            case  ProductSpecificationModel.specificationBody:
                    String featureTitle=productSpecificationModelList.get(position).getFeatureName();
                    String featureDetails=productSpecificationModelList.get(position).getFeatureValue();
                    viewHolder.setFeatures(featureTitle,featureDetails);
                    break;

                    default:return;
        }


    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;
        private  TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        private void setTitle(String titleText){
            title= (TextView) itemView;
            title.setText(titleText);
        }
        private void setFeatures(String featureTitle,String featureDetails){
            featureName=itemView.findViewById(R.id.feature_name);
            featureValue=itemView.findViewById(R.id.feature_value);
            featureName.setText(featureTitle);
            featureValue.setText(featureDetails);
        }
    }
    private int setDp(int dp, Context context){
         return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());

    }
}
