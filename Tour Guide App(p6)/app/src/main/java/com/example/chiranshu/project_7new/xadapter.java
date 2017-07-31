package com.example.chiranshu.project_7new;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chiranshu on 14-04-2017.
 */

public class xadapter extends ArrayAdapter<ximg>
{
    public xadapter(Activity context, ArrayList<ximg> X) {
        super(context, 0, X);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listof_ItemView= convertView;
        if(listof_ItemView==null){
            listof_ItemView= LayoutInflater.from(getContext()).inflate(R.layout.sub_list,parent,false);
        }
        ximg currentximg=getItem(position);

        TextView n_text=(TextView) listof_ItemView.findViewById(R.id.p_txt);
        n_text.setText(currentximg.getPlace2());

        ImageView V_icon=(ImageView) listof_ItemView.findViewById(R.id.imge);
        V_icon.setImageResource(currentximg.getimg_resource2());

        return listof_ItemView;}
}

