package com.example.chiranshu.project_7new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by chiranshu on 15-04-2017.
 */

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ImageView c1_img=(ImageView) findViewById(R.id.activity_chennai);
        c1_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent to_src=new Intent(menu.this,chennai.class);
                startActivity(to_src);
            }
        });

        ImageView j1_img=(ImageView) findViewById(R.id.Jammu);
        j1_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent to_src=new Intent(menu.this,Jammu.class);
                startActivity(to_src);
            }
        });

        ImageView mn1_img=(ImageView) findViewById(R.id.activity_manali);
        mn1_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent to_src=new Intent(menu.this,manali.class);
                startActivity(to_src);
            }
        });


        ImageView r1_img=(ImageView) findViewById(R.id.activity_rajasthan);
        r1_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent to_src=new Intent(menu.this,rajasthan.class);
                startActivity(to_src);
            }
        });

        ImageView s1_img=(ImageView) findViewById(R.id.activity_shimla);
        s1_img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent to_src=new Intent(menu.this,shimla.class);

                startActivity(to_src);    }
        });




    }}

