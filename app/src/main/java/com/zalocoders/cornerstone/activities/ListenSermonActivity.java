package com.zalocoders.cornerstone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jean.jcplayer.JcAudio;
import com.example.jean.jcplayer.JcPlayerView;
import com.zalocoders.cornerstone.R;

import java.util.ArrayList;

public class ListenSermonActivity extends AppCompatActivity  {
    JcPlayerView jcplayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_sermon);


        jcplayerView = findViewById(R.id.jcplayerView);

        ArrayList<JcAudio> jcAudios = new ArrayList<>();

        jcAudios.add(JcAudio.createFromURL("url audio","http://vprbbc.streamguys.net:80/vprbbc24.mp3"));

        jcplayerView.createNotification();

        jcplayerView.initPlaylist(jcAudios);
    }


    @Override
    protected void onPause() {
        super.onPause();
        jcplayerView.kill();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        jcplayerView.kill();

    }
}
