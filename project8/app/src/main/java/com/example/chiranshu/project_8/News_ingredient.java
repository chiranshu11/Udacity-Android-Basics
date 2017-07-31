package com.example.chiranshu.project_8;

/**
 * Created by chiranshu on 26-04-2017.
 */
public class News_ingredient {
    private String headline;
    private String short_url;
    private String type;

    private String img_resource;

    public News_ingredient(String headline1, String headline2, String headline3, String img_resource1) {
        headline = headline1;
        short_url = headline2;
        type = headline3;
        img_resource = img_resource1;
    }

    public String getheadline1() {
        return headline;
    }

    public String gettype() {
        return type;
    }

    public String getSurl2() {
        return short_url;
    }


    public String getimg_resource2() {
        return img_resource;
    }
}
