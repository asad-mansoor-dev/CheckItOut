package com.asad.checkitout.ui.slideshow;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.asad.checkitout.GridProductLayoutAdapter;
import com.asad.checkitout.GridProductModel;
import com.asad.checkitout.R;
import com.asad.checkitout.ui.gallery.GalleryFragment;
import com.asad.checkitout.ui.home.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private GridView gridView;
    private List<GridProductModel> gridProductModelList = new ArrayList<GridProductModel>();
    private GridProductLayoutAdapter gridProductLayoutAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridProductModelList.add(new GridProductModel(R.mipmap.search_icon, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.cart_icon, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.findglasses, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.my_menu, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.logo_round, "Rs 5000/-"));
        gridProductModelList.add(new GridProductModel(R.mipmap.green_email, "Rs 5000/-"));


        //gridView = (GridView) view.findViewById(R.id.grid_product_layout_gridview);
        //gridProductLayoutAdapter = new GridProductLayoutAdapter(getContext(), gridProductModelList);
        //gridView.setAdapter(gridProductLayoutAdapter);

    }
}
