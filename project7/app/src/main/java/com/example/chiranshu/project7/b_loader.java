package com.example.chiranshu.project7;

import android.content.Context;

import java.util.List;


public class b_loader extends android.content.AsyncTaskLoader<List<flavor>> {
    private String N_Url;

    public b_loader(Context context, String UrL) {
        super(context);
        N_Url = UrL;
    }


    @Override
    public void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<flavor> loadInBackground() {
        if (N_Url == null) {
            return null;
        }
        List<flavor> books_result = loading_books.loading_books(N_Url);
        return books_result;
    }
}
