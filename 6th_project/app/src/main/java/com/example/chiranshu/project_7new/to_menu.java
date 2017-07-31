package com.example.chiranshu.project_7new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by chiranshu on 14-04-2017.
 */

public class to_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_menu);

        TextView menu1=(TextView) findViewById(R.id.Start);
        menu1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent to_sr1=new Intent(to_menu.this,menu.class);
                startActivity(to_sr1);
            }
        });
    }}

