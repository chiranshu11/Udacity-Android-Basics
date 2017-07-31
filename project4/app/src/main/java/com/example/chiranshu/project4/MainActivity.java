package com.example.chiranshu.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView recent_image = (ImageView) findViewById(R.id.recent_button);
        recent_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity1 = new Intent(MainActivity.this, Recent.class);
                startActivity(activity1);
            }
        });
        ImageView back_image = (ImageView) findViewById(R.id.back_button);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity2 = new Intent(MainActivity.this, Back_To_Menu.class);
                startActivity(activity2);
            }
        });
        ImageView search_image = (ImageView) findViewById(R.id.search_button);
        search_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity3 = new Intent(MainActivity.this, Search.class);
                startActivity(activity3);
            }
        });

        ImageView play_image = (ImageView) findViewById(R.id.play_button);
        play_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView play = (ImageView) findViewById(R.id.play_button);
                play.setImageResource(R.drawable.pause);
        //        Media player class will used to play sound and videos and audio manager to manage audio src and audio output on the device

            }
        });

        ImageView repeat_image = (ImageView) findViewById(R.id.repeat_button);
        repeat_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView repeat = (ImageView) findViewById(R.id.repeat_button);
                repeat.setImageResource(R.drawable.repeat_c);
                //
            }
        });

        ImageView shuffle_image = (ImageView) findViewById(R.id.shuffle_button);
        shuffle_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView shuffle = (ImageView) findViewById(R.id.shuffle_button);
                shuffle.setImageResource(R.drawable.shuffle_c);
                //
            }
        });}};