package com.example.chiranshu.p10.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.chiranshu.p10.data.i_Contract.I_Entry;
/**
 * Created by chiranshu on 09-05-2017.
 */

public class i_DbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = com.example.chiranshu.p10.data.i_DbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    public i_DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_I_TABLE =  "CREATE TABLE " + I_Entry.TABLE_NAME + " ("
                + I_Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + I_Entry.COLUMN_I_NAME + " TEXT NOT NULL, "
                + I_Entry.COLUMN_I_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                + I_Entry.COLUMN_I_PRICE + " INTEGER NOT NULL, "
                + I_Entry.COLUMN_I_MAIL + " TEXT, "
                + I_Entry.COLUMN_I_IMAGE + " TEXT NOT NULL );";
        Log.i(LOG_TAG,SQL_CREATE_I_TABLE);
        db.execSQL(SQL_CREATE_I_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}