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
public class MyCartFragment extends Fragment {


    public MyCartFragment() {
        // Required empty public constructor
    }
private RecyclerView cartItemsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);
        cartItemsRecyclerView=view.findViewById(R.id.cart_items_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.mipmap.prod1,"Mustard Top",2,"Rs.4999/-","Rs.5999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.prod2,"Another Top",1,"Rs.4999/-","Rs.5999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.prod3,"Again Another Top",3,"Rs.4999/-","Rs.5999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 Items)","Rs.15000/-","Free","Total of Rs.699/- Saved on this order","15000/-"));

        CartAdaptor cartAdaptor=new CartAdaptor(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdaptor);
        cartAdaptor.notifyDataSetChanged();

        return view;
    }

}
