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
public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }
    private RecyclerView wishlistRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_wishlist, container, false);
       wishlistRecyclerView=view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);
        List<WishListModel> wishListModelList=new ArrayList<>();
        wishListModelList.add(new WishListModel(R.mipmap.prod7,"Mustard Top",1,"4",145,"4999","5999","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.mipmap.prod2,"Mustard Top",3,"3",145,"4999","5999","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.mipmap.prod1,"Mustard Top",2,"4",145,"4999","5999","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.mipmap.prod3,"Mustard Top",1,"2",145,"4999","5999","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.mipmap.prod9,"Mustard Top",6,"4",145,"4999","5999","Cash on delivery"));
       WishListAdaptor wishListAdaptor=new WishListAdaptor(wishListModelList);
       wishlistRecyclerView.setAdapter(wishListAdaptor);
       wishListAdaptor.notifyDataSetChanged();
        return view;
    }

}
