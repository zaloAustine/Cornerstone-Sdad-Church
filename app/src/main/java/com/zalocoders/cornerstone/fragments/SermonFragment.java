package com.zalocoders.cornerstone.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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

import com.zalocoders.cornerstone.Adapters.SermonAdapter;
import com.zalocoders.cornerstone.Models.Sermon;
import com.zalocoders.cornerstone.R;
import com.zalocoders.cornerstone.viewModels.SermonViewModel;

import java.util.ArrayList;
import java.util.List;

public class SermonFragment extends Fragment {

    private SermonViewModel mViewModel;
    View v;
    Context mContext;
    RecyclerView sermons;
    List<Sermon> mSermonList;

    public static SermonFragment newInstance() {
        return new SermonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.sermon_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(SermonViewModel.class);
        mContext = container.getContext();

        mSermonList = new ArrayList<>();

        setUpRecyclerView();
        return v;
    }

    private void setUpRecyclerView() {
        sermons = v.findViewById(R.id.sermons);
        SermonAdapter adapter = new SermonAdapter(mContext,mSermonList);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        sermons.setLayoutManager(manager);

        LoadSermons();

        sermons.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    public SermonFragment() {
    }

    public void LoadSermons(){

        mViewModel.getSermons().observe(getViewLifecycleOwner(), new Observer<List<Sermon>>() {
            @Override
            public void onChanged(List<Sermon> sermons) {
                mSermonList.addAll(sermons);
            }
        });
    }
}
