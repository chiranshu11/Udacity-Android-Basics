package com.example.chiranshu.project7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class badapter extends ArrayAdapter<flavor> {
    public badapter(Context context, ArrayList<flavor> b) {
        super(context, 0, b);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listof_ItemView = convertView;
        if (listof_ItemView == null) {
            listof_ItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_view, parent, false);
        }
        flavor currentflavor = getItem(position);

        TextView searched_text = (TextView) listof_ItemView.findViewById(R.id.name);
        String searched = currentflavor.getPlace2();
        searched_text.setText(searched);

        ImageView V_icon = (ImageView) listof_ItemView.findViewById(R.id.image);
        Picasso.with(getContext()).load(currentflavor.getimg_resource2()).into(V_icon);
        return listof_ItemView;
    }

}
