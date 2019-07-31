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
public class MyOrdersFragment extends Fragment {

private RecyclerView myOrdersRecyclerview;
    public MyOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrdersRecyclerview=view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerview.setLayoutManager(layoutManager);
        List<MyOrderItemModel> myOrderItemModelList=new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.prod7,2,"Mustard tops","Delivered on Monday,15th Jan 2019"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.prod1,1,"Jeans Denim","Delivered on Monday,15th Jan 2019"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.prod2,0,"Another Demo tops","Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.mipmap.prod4,4,"Another tops","Delivered on Monday,15th Jan 2019"));


        MyOrderAdaptor myOrderAdaptor=new MyOrderAdaptor(myOrderItemModelList);
        myOrdersRecyclerview.setAdapter(myOrderAdaptor);
        myOrderAdaptor.notifyDataSetChanged();

        return view;
    }

}
