package com.asad.checkitout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.badge.BadgeDrawable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SearchView searchView;
    private List<GridProductModel> gridProductModelList;
    private  SearchItemsAdapter searchItemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        gridProductModelList = new ArrayList<>();
        searchView = (SearchView)findViewById(R.id.search_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar_in_search_view);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        toolbar.setNavigationContentDescription("go back");
        getSupportActionBar().setDisplayShowTitleEnabled(false);


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        searchView = (SearchView)findViewById(R.id.search_view);
        SearchView.SearchAutoComplete searchAutoComplete =
                (SearchView.SearchAutoComplete)searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        try {
            Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            mCursorDrawableRes.setAccessible(true);
            mCursorDrawableRes.set(searchTextView, 0); //This sets the cursor resource ID to 0 or @null which will make it visible on white background
        } catch (Exception e) {
        }

        final SearchView searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        final EditText searchEditText = (EditText) searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.colorBlack));
        searchEditText.setHintTextColor(getResources().getColor(R.color.colorBlack));
        searchEditText.setLinkTextColor(getResources().getColor(R.color.colorBlack));

        /*Button searchCloseButton = (Button) searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        searchCloseButton.setBackgroundColor(getResources().getColor(R.color.colorBlack));*/

        ImageView searchButton = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_button);
        searchButton.setColorFilter(ContextCompat.getColor(this, R.color.colorBlack), android.graphics.PorterDuff.Mode.SRC_IN);

        ImageView searchImageIcon = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        searchImageIcon.setColorFilter(ContextCompat.getColor(this, R.color.colorBlack), android.graphics.PorterDuff.Mode.SRC_IN);

        ImageView searchCloseButton = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        searchCloseButton.setColorFilter(ContextCompat.getColor(this, R.color.colorBlack), android.graphics.PorterDuff.Mode.SRC_IN);

        ImageView searchMagIcon = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        searchMagIcon.setColorFilter(ContextCompat.getColor(this, R.color.colorBlack), android.graphics.PorterDuff.Mode.SRC_IN);

        searchView.setIconified(false);
        searchCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
                ((SearchView) findViewById(R.id.search_view)).setIconified(false);
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                finish();
                return true;
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        gridProductModelList.add(new GridProductModel(R.mipmap.search_icon, "Rs 5000/-", "Vincent Chase"));
        gridProductModelList.add(new GridProductModel(R.mipmap.cart_icon, "Rs 5000/-", "Google glasses"));
        gridProductModelList.add(new GridProductModel(R.mipmap.findglasses, "Rs 5000/-", "Sun Glasses"));
        gridProductModelList.add(new GridProductModel(R.mipmap.my_menu, "Rs 5000/-", "Swimming Glasses"));
        gridProductModelList.add(new GridProductModel(R.mipmap.logo_round, "Rs 5000/-", "Blacky Glasses"));
        gridProductModelList.add(new GridProductModel(R.mipmap.green_email, "Rs 5000/-", "White Googles"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_search);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        searchItemsAdapter= new SearchItemsAdapter(getApplicationContext(),gridProductModelList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(searchItemsAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                searchView.setFocusable(true);
//                searchView.requestFocus();
//                searchView.requestFocusFromTouch();
//                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                searchItemsAdapter.getFilter().filter(newText);
                return false;
            }
        });

        }
}
