package com.example.chiranshu.project_8;

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


public class News extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News_ingredient>> {

    private News_adapter news_list_adapter;
    private ImageView noNet;
    private ImageView noResult;
    private static String fetch_url = "https://content.guardianapis.com/search?api-key=e4470328-f0a2-475a-a820-a0c0f2857b37&page-size=10&order-by=newest&show-fields=,headline,thumbnail,short-url";
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView Viewing_news = (ListView) findViewById(R.id.activity_list);
        noNet = (ImageView) findViewById(R.id.no_net_image);
        noResult = (ImageView) findViewById(R.id.no_result);
        progressBar = findViewById(R.id.indicator);
        noNet.setVisibility(View.GONE);
        noResult.setVisibility(View.GONE);
        news_list_adapter = new News_adapter(this, new ArrayList<News_ingredient>());

        Viewing_news.setAdapter(news_list_adapter);

        Viewing_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                News_ingredient cnews = news_list_adapter.getItem(position);
                Uri newsUri = Uri.parse(cnews.gettype());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(websiteIntent);
            }
        });


        LoaderManager Loading = null;
        ConnectivityManager connectivity_Manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo n_info = connectivity_Manager.getActiveNetworkInfo();

        if (n_info != null && n_info.isConnected()) {
            Loading = getLoaderManager();
            Loading.initLoader(1, null, this);
            noNet.setVisibility(View.GONE);
            noResult.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            noResult.setVisibility(View.GONE);
            noNet.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public Loader<List<News_ingredient>> onCreateLoader(int id, Bundle args) {
        noResult.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        return new news_loader(News.this, fetch_url);
    }


    @Override
    public void onLoadFinished(Loader<List<News_ingredient>> loader, List<News_ingredient> News_ingredients) {
        news_list_adapter.clear();
        if (News_ingredients != null && !News_ingredients.isEmpty()) {
            news_list_adapter.addAll(News_ingredients);
        } else {
            noResult.setVisibility(View.VISIBLE);
        }
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onLoaderReset(Loader<List<News_ingredient>> loader) {
        news_list_adapter.clear();
    }
}
