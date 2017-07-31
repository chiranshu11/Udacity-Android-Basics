package com.example.chiranshu.project_7new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chiranshu on 14-04-2017.
 */

public class rajasthan extends AppCompatActivity {

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_list);

        ArrayList<ximg> r_img=new ArrayList<ximg>();
        r_img.add(new ximg(R.string.a_r,R.drawable.amberfort));
        r_img.add(new ximg(R.string.j_f_r,R.drawable.jaisalmer_fort));
        r_img.add(new ximg(R.string.h_m,R.drawable.hawa_mahal_1));
        r_img.add(new ximg(R.string.c_r,R.drawable.citypalace_jaipur));
        r_img.add(new ximg(R.string.j_r, R.drawable.jantar_mantar));
        r_img.add(new ximg(R.string.d_t_r,R.drawable.dilwara_temple));

        xadapter Manaliadapter= new xadapter(this, r_img);
        ListView l_v= (ListView) findViewById(R.layout.r_list);
        l_v.setAdapter(Manaliadapter);
    };
}


