package com.delvo.commerce;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }
    private RecyclerView categoryRecyclerView;
    private CategoryAdaptor categoryAdaptor;
    private  RecyclerView testing;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView=view.findViewById(R.id.category_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);



        categoryModelList=new ArrayList<CategoryModel>();
        categoryAdaptor=new CategoryAdaptor(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdaptor);


        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
         if(task.isSuccessful()){
             for (QueryDocumentSnapshot documentSnapshot : task.getResult()){

                 categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("categoryName").toString()));

         }
             categoryAdaptor.notifyDataSetChanged();

}else{
    String error=task.getException().getMessage();
    Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
}
                    }
                });







        //////// Bannner Slider

        List<SliderModel> sliderModelList =new ArrayList<SliderModel>();


        sliderModelList.add(new SliderModel(R.mipmap.bannernew1,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.bannernew2,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.bannernew3,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.bannernew4,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.bannernew5,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.bannernew6,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.bannernew7,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.lakmi1,"#FFFFFF"));


  //////// Bannner Slider


        //////// strip ad layout



        //////// strip ad layout

        //////// horizontal product layout


List<HorizontalProductScrollModel> horizontalProductScrollModelList=new ArrayList<>();



horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod1,"Redmi 5A","6P 625 processor","Rs.2900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod1,"Redmi 5A","6P 625 processor","Rs.2900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod2,"Redmi 5A","6P 625 processor","Rs.2900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod3,"Redmi 5A","6P 625 processor","Rs.2900/-"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod4,"Redmi 5A","6P 625 processor","Rs.2900/-"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod5,"Redmi 5A","6P 625 processor","Rs.2900/-"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod6,"Redmi 5A","6P 625 processor","Rs.2900/-"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod7,"Redmi 5A","6P 625 processor","Rs.2900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod8,"Redmi 5A","6P 625 processor","Rs.2900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod9,"Redmi 5A","6P 625 processor","Rs.2900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.prod10,"Redmi 5A","6P 625 processor","Rs.2900/-"));



        //////// horizontal product layout

        //////// Test
        testing=view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripnew,"#ffffff"));
        homePageModelList.add(new HomePageModel(3,"DEALS OF THE DAY",horizontalProductScrollModelList));
        //homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripnew7,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"NEW SHADES",horizontalProductScrollModelList));

        //homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripnew3,"#ffffff"));
       // homePageModelList.add(new HomePageModel(3,"Deals Of The Day",horizontalProductScrollModelList));
        //homePageModelList.add(new HomePageModel(1,R.mipmap.stripa,"#ffffff"));
      //  homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(3,"CLEARANCE SELL",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripnew,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"NEW PRODUCTS",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripnew7,"#ffffff"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //////// Test
        return view;
    }
    //////// Bannner Slider



}
