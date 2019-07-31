package com.delvo.commerce;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryRecyclerView=findViewById(R.id.category_recyclerview);

        //////// Bannner Slider

        List<SliderModel>sliderModelList=new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.mipmap.banner5,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner6,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner,"#FFFFFF"));

        sliderModelList.add(new SliderModel(R.mipmap.banner1,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner2,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner3,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner4,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner5,"#FFFFFF"));

        sliderModelList.add(new SliderModel(R.mipmap.banner6,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner,"#FFFFFF"));
        sliderModelList.add(new SliderModel(R.mipmap.banner1,"#FFFFFF"));

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

        //////// grid product layout

        //////// Test

        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripad2,"#ffffff"));
        homePageModelList.add(new HomePageModel(3,"Deals Of The Day",horizontalProductScrollModelList));
        //homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripad3,"#ffffff"));
        homePageModelList.add(new HomePageModel(2,"Products Under 499/-",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"New Products",horizontalProductScrollModelList));
        //homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripad2,"#ffffff"));
        // homePageModelList.add(new HomePageModel(3,"Deals Of The Day",horizontalProductScrollModelList));
        //homePageModelList.add(new HomePageModel(1,R.mipmap.stripa,"#ffffff"));
        //homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(3,"Clearance Sell",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripad2,"#ffffff"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            return true;
        }else if(id==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
