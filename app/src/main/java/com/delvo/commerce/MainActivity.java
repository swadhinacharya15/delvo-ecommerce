package com.delvo.commerce;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int HOME_FRAGMENT=0;
    private static final int CART_FRAGMENT=1;
    private static final int ORDERS_FRAGMENT=2;
    private FrameLayout frameLayout;
    private static int currentFragment = -1;
    private static int WISHLIST_FRAGMENT = 3;
    private static int REWARDS_FRAGMENT = 4;
    private static int ACCOUNT_FRAGMENT =5;
    private NavigationView navigationView;
    private ImageView actionBarLogo;
    private Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        actionBarLogo=findViewById(R.id.actionbar_logo);
        setSupportActionBar(toolbar);
        window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout=findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment==HOME_FRAGMENT){
                super.onBackPressed();
            }else {
                actionBarLogo.setVisibility(View.VISIBLE);
                invalidateOptionsMenu();
                setFragment(new HomeFragment(),HOME_FRAGMENT);
                navigationView.getMenu().getItem(0).setChecked(true);

            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == HOME_FRAGMENT) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.main, menu);

        }
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
            gotoFragment("My Cart",new MyCartFragment(),CART_FRAGMENT);
            return true;
        }else if(id==R.id.main_notification_icon){
            return true;
        }else if(id==R.id.main_search_icon){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String title,Fragment fragment,int fragmentNo) {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        actionBarLogo.setVisibility(View.GONE);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentNo);
        if (fragmentNo==CART_FRAGMENT) {

            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_delvo) {

            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(),HOME_FRAGMENT);
            // Handle the camera action
        } else if (id == R.id.nav_my_orders) {
            gotoFragment("My Orders",new MyOrdersFragment(),ORDERS_FRAGMENT);

        } else if (id == R.id.nav_my_rewards) {
            gotoFragment("My Rewards",new MyRewardFragment(),REWARDS_FRAGMENT);
        } else if (id == R.id.nav_my_cart) {
            gotoFragment("My Cart",new MyCartFragment(),CART_FRAGMENT);

        } else if (id == R.id.nav_my_wishlist) {
            gotoFragment("My Wishlist",new MyWishlistFragment(),WISHLIST_FRAGMENT);
        }
        else if (id == R.id.nav_my_account) {

            gotoFragment("My Account",new MyAccountFragment(),ACCOUNT_FRAGMENT);
        }
        else if (id == R.id.nav_sign_out) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setFragment(Fragment fragment,int fragmentNo){

        if (fragmentNo!=currentFragment) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            currentFragment=fragmentNo;

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }
}
