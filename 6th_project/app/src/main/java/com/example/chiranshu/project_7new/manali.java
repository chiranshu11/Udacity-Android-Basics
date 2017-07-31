package com.example.chiranshu.project_7new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chiranshu on 14-04-2017.
 */


public class manali extends AppCompatActivity {

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_list);

        ArrayList<ximg> m_img=new ArrayList<ximg>();
        m_img.add(new ximg(R.string.h_m,R.drawable.hidimba_temple_manali));
        m_img.add(new ximg(R.string.s_v_m,R.drawable.solang_valley));
        m_img.add(new ximg(R.string.r_m,R.drawable.rohtang_pass));
        m_img.add(new ximg(R.string.v_m,R.drawable.van_vihar_manali));
        m_img.add(new ximg(R.string.m_m,R.drawable.manalibazar));

        xadapter Manaliadapter= new xadapter(this, m_img);
        ListView l_v= (ListView) findViewById(R.layout.m_list);
        l_v.setAdapter(Manaliadapter);
    };
}

