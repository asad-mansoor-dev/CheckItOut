package com.asad.checkitout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recycler_view);


        /////////////////// Baner SLider

        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.app_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_black,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));



        //////////////////  Baner Slider

        //////////// Strip Ad

        //////////// Strip Ad

        /////////// Horizontal Product Layout



        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.mobile, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.logo, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.home_icon, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.profile_placeholder, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.my_wishlist, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.red_email, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.green_email, "Redmi 5A", "SD 625 Processor", "Rs. 5999/-"));


        /////////// Horizontal Product Layout



        //////////////////////////


        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(RecyclerView.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripadd ,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.banner ,"#ffff00"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.banner ,"#ffff00"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView    .setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.main_search_icon){

            // todo : search
            return true;
        } else if(id == android.R.id.home){
            finish();
            return true;
        } else if(id == R.id.main_notification_icon){

            // todo : notification
            return true;
        } else if(id == R.id.main_cart_icon){

            // todo : cart
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
