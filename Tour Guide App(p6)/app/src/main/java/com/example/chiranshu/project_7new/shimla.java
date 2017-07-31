package com.example.chiranshu.project_7new;

/**
 * Created by chiranshu on 14-04-2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class shimla extends AppCompatActivity {

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_list);

        ArrayList<ximg> s_img=new ArrayList<ximg>();
        s_img.add(new ximg(R.string.j_s,R.drawable.shimla1));
        s_img.add(new ximg(R.string.t_r_s,R.drawable.the_ridge_shimla));
        s_img.add(new ximg(R.string.cc_s,R.drawable.church_shimla));
        s_img.add(new ximg(R.string.r_s,R.drawable.rashtrapati_niwas_shimla));
        s_img.add(new ximg(R.string.s_v_m,R.drawable.shimla_wax_museum));
        s_img.add(new ximg(R.string.m_s,R.drawable.mall_road_shimla));

        xadapter Manaliadapter= new xadapter(this, s_img);
        ListView l_v= (ListView) findViewById(R.layout.s_list);
        l_v.setAdapter(Manaliadapter);
    };
}

