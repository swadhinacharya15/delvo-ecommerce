package com.delvo.commerce;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSpecificationFragment extends Fragment {


    public ProductSpecificationFragment() {
        // Required empty public constructor
    }
private RecyclerView productSpecificationRecylerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecificationRecylerView=view.findViewById(R.id.product_specification_recyclerview);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productSpecificationRecylerView.setLayoutManager(linearLayoutManager);
        List<ProductSpecificationModel> productSpecificationModelList=new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General Details 1"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Available Size","28,32,34,36"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Color","Denim"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General Details 2"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Gender","Women"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Category","Clothing"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General Details 3"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","Puma"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Category","Clothing"));

        ProductSpecificationAdaptor productSpecificationAdaptor=new ProductSpecificationAdaptor(productSpecificationModelList);
        productSpecificationRecylerView.setAdapter(productSpecificationAdaptor);
        productSpecificationAdaptor.notifyDataSetChanged();

    return view;

    }

}
