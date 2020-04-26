package com.zalocoders.cornerstone.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.teleclinic.bulent.smartimageview.SmartImageViewLayout;
import com.zalocoders.cornerstone.Adapters.ViewPagerAdapter;
import com.zalocoders.cornerstone.R;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem home,events,tithe;
    ViewPagerAdapter pageAdapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        images1 = findViewById(R.id.images1);
//        String[] images = {"https://homepages.cae.wisc.edu/~ece533/images/airplane.png","https://homepages.cae.wisc.edu/~ece533/images/arctichare.png","https://homepages.cae.wisc.edu/~ece533/images/barbara.bmp","https://homepages.cae.wisc.edu/~ece533/images/airplane.png","https://homepages.cae.wisc.edu/~ece533/images/arctichare.png","https://homepages.cae.wisc.edu/~ece533/images/barbara.bmp"};
//        images1.putImages(images);


        initViews();
        setUpViewPager();

    }

    private void setUpViewPager() {
        pageAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(this);

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        switch (tab.getPosition()){
            case 0:
                getSupportActionBar().setTitle("Cornerstone News");
                break;
            case 1:
                getSupportActionBar().setTitle("Discover Cornerstone");
                break;
            case 2:
                getSupportActionBar().setTitle("Cornerstone Sermons");
                break;
            case 3:
                getSupportActionBar().setTitle("Cornerstone Giving");
                break;
            case 4:
                getSupportActionBar().setTitle("Hymnal");
                break;
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
