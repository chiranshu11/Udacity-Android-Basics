package com.example.chiranshu.project_8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class News_adapter extends ArrayAdapter<News_ingredient> {
    public News_adapter(Context context, ArrayList<News_ingredient> b) {
        super(context, 0, b);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listof_ItemView = convertView;
        if (listof_ItemView == null) {
            listof_ItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main2, parent, false);
        }
        News_ingredient currentNews_ingredient = getItem(position);

        TextView News_type = (TextView) listof_ItemView.findViewById(R.id.type);
        String searched1 = currentNews_ingredient.getheadline1();
        News_type.setText(searched1);


        TextView News_title = (TextView) listof_ItemView.findViewById(R.id.title);
        String searched = currentNews_ingredient.getSurl2();
        News_title.setText(searched);

        TextView News_URL = (TextView) listof_ItemView.findViewById(R.id.url);
        String searched2 = currentNews_ingredient.gettype();
        News_URL.setText(searched2);



        ImageView V_icon = (ImageView) listof_ItemView.findViewById(R.id.image);
        Picasso.with(getContext()).load(currentNews_ingredient.getimg_resource2()).into(V_icon);
        return listof_ItemView;
    }

}
