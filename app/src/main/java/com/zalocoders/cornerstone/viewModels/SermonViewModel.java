package com.zalocoders.cornerstone.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.zalocoders.cornerstone.Models.News;
import com.zalocoders.cornerstone.Models.Sermon;

import java.util.ArrayList;
import java.util.List;

public class SermonViewModel extends ViewModel {
MutableLiveData<List<Sermon>> mListMutableLiveData;
    List<Sermon> mSermonList = new ArrayList<>();
    // TODO: Implement the ViewModel


    public MutableLiveData<List<Sermon>> getSermons(){

        mListMutableLiveData = new MutableLiveData<>();

        Sermon sermon = new Sermon();
        sermon.setAudoUrl("");
        sermon.setDate("24");
        sermon.setTopic("Living in christ");
        sermon.setDescription("Listen To the sermon of living with christ");
        sermon.setPastor("David Mwangi");

        for(int i=0;i<=20;i++){
            mSermonList.add(sermon);
        }


mListMutableLiveData.setValue(mSermonList);

        return mListMutableLiveData;
    }
}
