package com.example.chiranshu.project7;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class searched_list extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<flavor>> {
    private badapter bladapter;
    private ImageView noNet;
    private ImageView noResult;
    private static String fetch_url = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1";
    private View progressBar;
    private static final int book_loader = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView Viewing = (ListView) findViewById(R.id.l_view);
        noNet = (ImageView) findViewById(R.id.no_net_image);
        noResult = (ImageView) findViewById(R.id.no_result);
        progressBar = findViewById(R.id.indicator);
        noNet.setVisibility(View.GONE);
        noResult.setVisibility(View.GONE);
        bladapter = new badapter(this, new ArrayList<flavor>());
        Viewing.setAdapter(bladapter);
        Viewing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                flavor cBooks = bladapter.getItem(position);
                Uri booksUri = Uri.parse(cBooks.getBooks_uri1());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, booksUri);
                startActivity(websiteIntent);
            }
        });
        LoaderManager Loading = null;
        Intent i = getIntent();
        String searched = i.getStringExtra("word");
        fetch_url = "https://www.googleapis.com/books/v1/volumes?q=" + searched + "&maxResults=8";
        ConnectivityManager connectivity_Manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo n_info = connectivity_Manager.getActiveNetworkInfo();

        if (n_info != null && n_info.isConnected()) {
            Loading = getLoaderManager();
            Loading.initLoader(book_loader, null, this);
            noNet.setVisibility(View.GONE);
            noResult.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            noResult.setVisibility(View.GONE);
            noNet.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public Loader<List<flavor>> onCreateLoader(int id, Bundle args) {
        noResult.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        return new b_loader(this, fetch_url);
    }


    @Override
    public void onLoadFinished(Loader<List<flavor>> loader, List<flavor> flavors) {
        bladapter.clear();
        if (flavors != null && !flavors.isEmpty()) {
            bladapter.addAll(flavors);
        } else {
            noResult.setVisibility(View.VISIBLE);
        }
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onLoaderReset(Loader<List<flavor>> loader) {
        bladapter.clear();
    }
}