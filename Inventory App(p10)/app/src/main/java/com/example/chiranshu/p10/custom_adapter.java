package com.example.chiranshu.p10;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chiranshu.p10.data.i_Contract;

/**
 * Created by chiranshu on 09-05-2017.
 */

public class custom_adapter extends CursorAdapter {

    public custom_adapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.inventory_item, parent, false);

    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        ImageView img = (ImageView) view.findViewById(R.id.img);

        TextView name = (TextView) view.findViewById(R.id.name);

        TextView price = (TextView) view.findViewById(R.id.price);

        ImageView add = (ImageView) view.findViewById(R.id.adder);

        TextView quantity = (TextView) view.findViewById(R.id.quantity);

        int name1 = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_NAME);
        int price1 = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_PRICE);
        int idColumnIndex = cursor.getColumnIndex(i_Contract.I_Entry._ID);
        int quantity1 = cursor.getColumnIndex(i_Contract.I_Entry.COLUMN_I_QUANTITY);

        String s_name = cursor.getString(name1);
        String s_image = cursor.getString(cursor.getColumnIndexOrThrow(i_Contract.I_Entry.COLUMN_I_IMAGE));
        String s_price = cursor.getString(price1);
        final String s_quantity = cursor.getString(quantity1);
        final String s_id = cursor.getString(idColumnIndex);


        if (s_image.startsWith("content://com.android.providers.media.documents/document/image")) {
            img.setImageURI(Uri.parse(s_image));
        } else {
            img.setImageResource(R.drawable.product);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(String.valueOf(s_quantity));
                if (quantity <= 0) {
                    Toast.makeText(context, R.string.not_in_stock, Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    ContentValues v = new ContentValues();
                    v.put(i_Contract.I_Entry.COLUMN_I_QUANTITY, quantity);
                    Uri uri = ContentUris.withAppendedId(i_Contract.I_Entry.CONTENT_URI, Long.parseLong(s_id));
                    context.getContentResolver().update(uri, v, null, null);
                }
            }
        });

        name.setText(s_name);
        quantity.setText(s_quantity);
        price.setText(s_price);

    }

}