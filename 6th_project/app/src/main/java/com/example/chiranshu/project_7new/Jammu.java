package com.example.chiranshu.project_7new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chiranshu on 14-04-2017.
 */

public class Jammu extends AppCompatActivity {

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ximg> j_img=new ArrayList<ximg>();
        j_img.add(new ximg(R.string.g_j,R.drawable.gulmarg_kashmir));
        j_img.add(new ximg(R.string.d_j,R.drawable.dul_lake_kasmir));
        j_img.add(new ximg(R.string.b_j,R.drawable.betab_v));
        j_img.add(new ximg(R.string.b_j,R.drawable.betabvalley));
        j_img.add(new ximg(R.string.p_j,R.drawable.pahalgam));
        j_img.add(new ximg(R.string.s_j,R.drawable.sonmarg_kashmir));

        xadapter Jammuadapter= new xadapter(this, j_img);
        ListView l_v= (ListView) findViewById(R.layout.j_list);
        l_v.setAdapter(Jammuadapter);
    }}
