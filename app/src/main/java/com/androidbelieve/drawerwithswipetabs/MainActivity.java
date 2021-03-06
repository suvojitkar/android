package com.androidbelieve.drawerwithswipetabs;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    static MainActivity activityA;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityA = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        /**
         *Setup the DrawerLayout and NavigationView
         */

             mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;


        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new Products()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

             mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                 if (menuItem.getItemId() == R.id.products) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Products()).commit();

                 }

                 if (menuItem.getItemId() == R.id.contactus) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Contactus()).commit();

                 }

                 if (menuItem.getItemId() == R.id.faq) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Faq()).commit();

                 }


                 if (menuItem.getItemId() == R.id.aboutus) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new AboutUs()).commit();

                 }

                 if (menuItem.getItemId() == R.id.finance) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Invoice()).commit();

                 }

                 if (menuItem.getItemId() == R.id.myaccount) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Myaccount()).commit();

                 }

                 if (menuItem.getItemId() == R.id.notification) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Notification()).commit();

                 }

                 if (menuItem.getItemId() == R.id.reports) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Reports()).commit();

                 }

                 if (menuItem.getItemId() == R.id.salesandmarketing) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Salesandmarketing()).commit();

                 }

                 if (menuItem.getItemId() == R.id.track) {
                     FragmentTransaction fragmentT = mFragmentManager.beginTransaction();
                     fragmentT.replace(R.id.containerView,new Tracking()).commit();

                 }




                 return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

                mDrawerLayout.setDrawerListener(mDrawerToggle);

                mDrawerToggle.syncState();

    }

    public static MainActivity getInstance(){
        return   activityA;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}