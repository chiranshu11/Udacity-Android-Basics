package com.example.chiranshu.project_8;

import android.content.Context;

import java.util.List;

/**
 * Created by chiranshu on 26-04-2017.
 */
public class news_loader extends android.content.AsyncTaskLoader<List<News_ingredient>> {
    private String N_Url;

    public news_loader(Context context, String UrL) {
        super(context);
        N_Url = UrL;
    }

    @Override
    public void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News_ingredient> loadInBackground() {
        if (N_Url == null) {
            return null;
        }
        List<News_ingredient> books_result = getting_News.News(N_Url);
        return books_result;
    }
}
