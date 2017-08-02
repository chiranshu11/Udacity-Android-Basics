package com.example.chiranshu.p10;

import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chiranshu.p10.data.i_Contract.I_Entry;

/**
 * Created by chiranshu on 09-05-2017.
 */

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int I_LOADER=1;
    custom_adapter icustom_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_intent = new Intent(MainActivity.this, data_recieving.class);
                startActivity(next_intent);
            }
        });
        ListView List = (ListView) findViewById(R.id.list);
        View emptyView = findViewById(R.id.empty);
        List.setEmptyView(emptyView);

        icustom_adapter=new custom_adapter(this,null);
        List.setAdapter(icustom_adapter);

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent next_intent = new Intent(MainActivity.this, data_recieving.class);
                Uri currentI_Uri = ContentUris.withAppendedId(I_Entry.CONTENT_URI, id);
                next_intent.setData(currentI_Uri);
                startActivity(next_intent);
            }
        });

        getLoaderManager().initLoader(I_LOADER, null, this);
    }

    private void insertInvetory() {
        ContentValues values = new ContentValues();
        values.put(I_Entry.COLUMN_I_NAME, "EXAMPLE");
        values.put(I_Entry.COLUMN_I_QUANTITY, "1");
        values.put(I_Entry.COLUMN_I_PRICE,"20" );
        values.put(I_Entry.COLUMN_I_MAIL,"xyz@gmail.com" );
        values.put(I_Entry.COLUMN_I_IMAGE, String.valueOf(getImageUri(R.drawable.product)));

        Uri newUri = getContentResolver().insert(I_Entry.CONTENT_URI, values);
    }

    private Uri getImageUri(int res1){
        Uri uri= Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE+ " :// " +
                        getResources().getResourcePackageName(res1)+" / " +
                        getResources().getResourceTypeName(res1)+ " / " +
                        getResources().getResourceEntryName(res1));

        return uri;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                insertInvetory();
                return true;
            case R.id.action_delete_all_entries:
                deleteAllInventory();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteAllInventory() {
        int rowsDeleted = getContentResolver().delete(I_Entry.CONTENT_URI, null, null);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        String[] projection = {
                I_Entry._ID,
                I_Entry.COLUMN_I_NAME,
                I_Entry.COLUMN_I_QUANTITY,
                I_Entry.COLUMN_I_PRICE,
                I_Entry.COLUMN_I_IMAGE};

        return new CursorLoader(this,
                I_Entry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        icustom_adapter.swapCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        icustom_adapter.swapCursor(null);

    }
}

