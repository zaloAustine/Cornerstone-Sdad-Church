package com.zalocoders.cornerstone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.zalocoders.cornerstone.R;

import java.util.Arrays;

public class ViewSongActivity extends AppCompatActivity {
    String descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_song);


        getValues();


    }



    public void getValues(){

        Intent i =getIntent();
        String titleText = i.getStringExtra("title");
         descriptionText = i.getStringExtra("description");

         arrangeSong();


        TextView title  = findViewById(R.id.title);
        title.setText(titleText);
        TextView description  = findViewById(R.id.description);
        description.setText(descriptionText.replaceAll("0*[1-9]\\d*","\n\n\n"));

    }

    private String arrangeSong() {
        String finalString =  "";

    char[] chars = descriptionText.toCharArray();

        Log.e("song",Arrays.toString(chars));

        finalString.replaceAll("0*[1-9]\\d*","\n\n\n");

        for(char ch:chars){

        }


    return finalString;

    }


}
