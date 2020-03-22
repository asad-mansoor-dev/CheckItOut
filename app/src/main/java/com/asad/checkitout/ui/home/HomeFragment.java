package com.asad.checkitout.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.gridlayout.widget.GridLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.asad.checkitout.GridProductLayoutAdapter;
import com.asad.checkitout.GridProductModel;
import com.asad.checkitout.R;
import com.asad.checkitout.ui.gallery.GalleryFragment;
import com.asad.checkitout.ui.slideshow.SlideshowFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private GridView gridView;
    private List<GridProductModel> gridProductModelList = new ArrayList<GridProductModel>();
    private GridProductLayoutAdapter gridProductLayoutAdapter;
    private TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.simpleTabLayout);

        // Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("First"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.ic_menu_camera); // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Second"); // set the Text for the second Tab
        secondTab.setIcon(R.drawable.ic_menu_gallery); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Third"); // set the Text for the first Tab
        thirdTab.setIcon(R.drawable.ic_menu_slideshow); // set an icon for the first tab
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
                        break;
                    case 1:
                        fragment = new GalleryFragment();
                        break;
                    case 2:
                        fragment = new SlideshowFragment();
                        break;
                }
                FragmentActivity fragmentActivity = new FragmentActivity();
                FragmentManager fm = fragmentActivity.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.layout.fragment_home, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                //ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        gridProductModelList.add(new GridProductModel(R.mipmap.search_icon, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.cart_icon, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.findglasses, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.my_menu, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.logo_round, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.green_email, "Rs 5000/-"));


        gridView = (GridView) view.findViewById(R.id.grid_product_layout_gridview);
        gridProductLayoutAdapter = new GridProductLayoutAdapter(getContext(), gridProductModelList);
        gridView.setAdapter(gridProductLayoutAdapter);

    }
}
