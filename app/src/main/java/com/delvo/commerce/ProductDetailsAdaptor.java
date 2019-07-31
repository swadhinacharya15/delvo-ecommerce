package com.delvo.commerce;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductDetailsAdaptor extends FragmentPagerAdapter {
private int totalTabs;

    public ProductDetailsAdaptor(FragmentManager fm,int totalTabs) {
        super(fm);
        this.totalTabs=totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
       switch (i){
           case 0:
               ProductsDescriptionFragment productsDescriptionFragment1=new ProductsDescriptionFragment();
                return productsDescriptionFragment1;

           case 1:
               ProductSpecificationFragment productSpecificationFragment=new ProductSpecificationFragment();
               return productSpecificationFragment ;
           case 2:
               ProductsDescriptionFragment productsDescriptionFragment2=new ProductsDescriptionFragment();
               return productsDescriptionFragment2;
               default:
                   return null;
       }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
