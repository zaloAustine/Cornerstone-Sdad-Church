package com.zalocoders.cornerstone.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalocoders.cornerstone.Adapters.NewsAdapter;
import com.zalocoders.cornerstone.Models.News;
import com.zalocoders.cornerstone.R;
import com.zalocoders.cornerstone.viewModels.FeedViewModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FeedFragment extends Fragment {

    private FeedViewModel mViewModel;
    NewsAdapter mNewsAdapter;
    View v;
    RecyclerView news_recyclerview;
    Context mContext;
    List<News> mNews;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.feed_fragment, container, false);
        mNewsAdapter = new NewsAdapter(mContext,mNews);

        mContext = container.getContext();
        mNews = new ArrayList<>();
        mNewsAdapter = new NewsAdapter(mContext,mNews);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FeedViewModel.class);
        setUpRecyclerView();
        // TODO: Use the ViewModel
    }

    public FeedFragment() {

    }


    private void setUpRecyclerView(){
        news_recyclerview = v.findViewById(R.id.news_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        news_recyclerview.setLayoutManager(linearLayoutManager);
        news_recyclerview.setAdapter(mNewsAdapter);

        loadData();

        mNewsAdapter.notifyDataSetChanged();

    }

    private void loadData() {
        mViewModel.getNews().observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {
                mNews.addAll(news);
            }
        });
    }





}
