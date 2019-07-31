package com.delvo.commerce;

import android.content.res.ColorStateList;
import android.graphics.Color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
     private ViewPager productImagesViewPager;
     private TabLayout viewPagerIndicator;
     private static Boolean ALREADY_ADDED_TO_WISHLIST=false;
     private FloatingActionButton addToWishlistBtn;
     private ViewPager productDetailsViewPager;
     private TabLayout productDetailsTabLayout;

     /////Raiting Layout
    private LinearLayout rateNowContener;

    /////Raiting Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager=findViewById(R.id.product_images_viewpager);
        viewPagerIndicator=findViewById(R.id.view_pager_indicator);
        addToWishlistBtn=findViewById(R.id.add_to_wishlist_btn);
        productDetailsViewPager=findViewById(R.id.product_details_viewpager);
        productDetailsTabLayout=findViewById(R.id.product_details_tab_layout);

        List<Integer> productImages= new ArrayList<>();
        productImages.add(R.mipmap.prod1);
        productImages.add(R.mipmap.prod2);
        productImages.add(R.mipmap.prod3);
        productImages.add(R.mipmap.prod4);
        productImages.add(R.mipmap.prod5);
        ProductImagesAdaptor productImagesAdaptor=new ProductImagesAdaptor(productImages);
        productImagesViewPager.setAdapter(productImagesAdaptor);


        viewPagerIndicator.setupWithViewPager(productImagesViewPager,true);
        addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (ALREADY_ADDED_TO_WISHLIST){
                 ALREADY_ADDED_TO_WISHLIST=false;
                  addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#BEBABA")));
             }else {
                 ALREADY_ADDED_TO_WISHLIST=true;
                 addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#FF0000")));
             }
            }
        });
productDetailsViewPager.setAdapter(new ProductDetailsAdaptor(getSupportFragmentManager(),productDetailsTabLayout.getTabCount()));
productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        productDetailsViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});
        /////Raiting Layout
        rateNowContener=findViewById(R.id.rate_now_contener);
        for (int x=0;x<rateNowContener.getChildCount();x++){
            final int starPosition=x;
            rateNowContener.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }


            });
        }
        /////Raiting Layout


    }
    private void setRating(int starPosition) {
        for (int x=0;x<rateNowContener.getChildCount();x++){
            ImageView starBtn=(ImageView)rateNowContener.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (x<=starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_cart_icon) {
            return true;
        }else if(id==R.id.main_search_icon){
            return true;
        }
        else if(id==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
