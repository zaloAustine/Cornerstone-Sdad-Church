package com.zalocoders.cornerstone.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.zalocoders.cornerstone.R;
import com.zalocoders.cornerstone.activities.GivingActivity;


public class GivingFragment extends Fragment {
    View v;
    MaterialButton give;
    Context mContext;
    public GivingFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContext = container.getContext();
        v =  inflater.inflate(R.layout.fragment_giving, container, false);
        give = v.findViewById(R.id.give);

        give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, GivingActivity.class);

                startActivity(i);
            }
        });
        return v;
    }
}
