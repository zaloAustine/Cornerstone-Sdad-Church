package com.zalocoders.cornerstone.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zalocoders.cornerstone.Models.News;

import java.util.ArrayList;
import java.util.List;

public class FeedViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    MutableLiveData<List<News>> mNewsMutableLiveData;
    List<News> mNewsList = new ArrayList<>();




    public MutableLiveData<List<News>> getNews(){

        mNewsMutableLiveData = new MutableLiveData<>();

        News n = new News();
        n.setDescription("Due to COVID-19 and the recommendation of the NC Governor, we are canceling church at all of our physical locations. Join us online Sunday at 9:30AM, 11:30AM, 2:00PM, 5:00PM, 8:00PM  10:00PM EDT");
        String[] images = {"https://wallpaperaccess.com/thumb/469742.jpg"};

        n.setImageUrls(images);

        News n1 = new News();
        n1.setDescription("Nature, in the broadest sense, is the natural, physical, or material world or universe. \"Nature\" can refer to the phenomena of the physical world, and also to life in general. ... Although humans are part of nature, human activity is often understood as a separate category from other natural phenomena.");
        String[] images1 = {"https://wallpaperaccess.com/thumb/469742.jpg","https://t3.ftcdn.net/jpg/02/48/92/96/240_F_248929619_JkVBYroM1rSrshWJemrcjriggudHMUhV.jpg","https://mcdn.wallpapersafari.com/small/23/93/dFlO8m.jpg","https://mcdn.wallpapersafari.com/small/91/40/6rKfeV.jpg"};

        n1.setImageUrls(images1);

        for(int i=0;i<=300;i++){

            mNewsList.add(n1);
            mNewsList.add(n);


        }

        mNewsMutableLiveData.setValue(mNewsList);

        return mNewsMutableLiveData;
    }
}
