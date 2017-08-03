package com.example.chiranshu.p9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.example.chiranshu.p9.HabitContract.HabitTable;

/**
 * Created by chiranshu on 12-05-2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HabitTable.db";
    public String not_Null = " NOT NULL ";
    public String A_Increment = " AUTOINCREMENT ";
    public String Integer = " INTEGER ";
    public String txt = " TEXT ";
    public String Primry_key = " PRIMARY KEY ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String HabitTable_table = " CREATE TABLE " + HabitTable.TABLE_NAME + " ("
                + HabitTable._ID + Integer + Primry_key + A_Increment + ","
                + HabitTable.weight + Integer + not_Null + ","
                + HabitTable.height + Integer + ","
                + HabitTable.doing_activity + txt + ","
                + HabitTable.activity + Integer + ")";
        db.execSQL(HabitTable_table);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DATABASE_NAME);
        onCreate(database);
    }

    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onUpgrade(database, oldVersion, newVersion);
    }

    public void addHabit() {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues HabitTable_tablevalues = new ContentValues();
        HabitTable_tablevalues.put(HabitTable.weight, "72");
        HabitTable_tablevalues.put(HabitTable.height, "160");
        HabitTable_tablevalues.put(HabitTable.doing_activity, "RUNNING");
        HabitTable_tablevalues.put(HabitTable.activity, "8hours ");
        database.insert(HabitTable.TABLE_NAME, null, HabitTable_tablevalues);


    }

    public Cursor Read() {
        Cursor cursor;
        SQLiteDatabase database = this.getReadableDatabase();
        String[] Projection = {HabitTable._ID, HabitTable.weight, HabitTable.height, HabitTable.doing_activity, HabitTable.activity};
        cursor = database.query(HabitTable.TABLE_NAME, Projection, null, null, null, null, null);
        return cursor;
    }
}