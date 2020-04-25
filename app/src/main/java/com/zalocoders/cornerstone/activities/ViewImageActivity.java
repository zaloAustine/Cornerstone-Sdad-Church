package com.zalocoders.cornerstone.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zalocoders.cornerstone.Adapters.SlidingImage_Adapter;
import com.zalocoders.cornerstone.Models.News;
import com.zalocoders.cornerstone.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ViewImageActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    List<String> IMAGES;

    private ArrayList<String> ImagesArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        IMAGES = new ArrayList<>();

        loadImages();
        init();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void loadImages() {
        Intent intent = getIntent();
        String news = intent.getStringExtra("News");

        Gson g = new Gson();
        News news1 = g.fromJson(news,News.class);

        Log.e("img",news);

        IMAGES.addAll(Arrays.asList(news1.getImageUrls()));

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {

        ImagesArray.addAll(IMAGES);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(ViewImageActivity.this, ImagesArray));


        final float density = getResources().getDisplayMetrics().density;


        NUM_PAGES = IMAGES.size()-1;

        if (currentPage == NUM_PAGES) {
            currentPage = 0;
        }
        mPager.setCurrentItem(currentPage++, true);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(ViewImageActivity.this,MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
