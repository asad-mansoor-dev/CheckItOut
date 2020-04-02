package com.asad.checkitout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.asad.checkitout.ui.gallery.GalleryFragment;
import com.asad.checkitout.ui.home.HomeFragment;
import com.asad.checkitout.ui.slideshow.SlideshowFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_account, R.id.nav_login)
                .setDrawerLayout(drawer)
                .build();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        //TAB LAYOUT WORKING
        // Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Men"); // set the Text for the first Tab
        //firstTab.setIcon(R.drawable.ic_menu_camera); // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Women"); // set the Text for the second Tab
        //secondTab.setIcon(R.drawable.ic_menu_gallery); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Kids"); // set the Text for the first Tab
        //thirdTab.setIcon(R.drawable.ic_menu_slideshow); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout

        // perform setOnTabSelectedListener event on TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        navigationView.getMenu().getItem(0).setChecked(true);
                        break;
                    case 1:
                        fragment = new GalleryFragment();
                        navigationView.getMenu().getItem(1).setChecked(true);
                        break;
                    case 2:
                        fragment = new SlideshowFragment();
                        navigationView.getMenu().getItem(2).setChecked(true);
                        break;
                }
                /*FragmentActivity fragmentActivity = new FragmentActivity();
                FragmentManager fm = fragmentActivity.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.layout.content_main, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();*/
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.nav_host_fragment, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.main_search_icon){
            startActivity(new Intent(getApplicationContext(),SearchActivity.class));
            return true;
        }
        else if(id == R.id.main_cart_icon) {
            //startActivity(new Intent(getApplicationContext(),ActivityForFragments.class));
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.activity_for_fragments, new MyCartFragment());
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//            ft.commit();

            Fragment fragment =new MyCartFragment();
            ft.add(android.R.id.content,fragment);
            ft.commit();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
