package com.example.chiranshu.project_7new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chiranshu on 14-04-2017.
 */
public class chennai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_list);

        ArrayList<ximg> c_img=new ArrayList<ximg>();
        c_img.add(new ximg(R.string.thomas_c,R.drawable.santhomebasilica));
        c_img.add(new ximg(R.string.k_c,R.drawable.k_temple));
        c_img.add(new ximg(R.string.f_c,R.drawable.fortst_george));
        c_img.add(new ximg(R.string.m_c,R.drawable.marinabeach));
        c_img.add(new ximg(R.string.e_c,R.drawable.edwardbeach));

        xadapter chennaiadapter= new xadapter(this, c_img);
        ListView l_v= (ListView) findViewById(R.id.c_list);
        l_v.setAdapter(chennaiadapter);
    }
}
