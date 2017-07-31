package com.example.chiranshu.project_8;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class getting_News {

    public static List<News_ingredient> News(String requestUrL) {
        URL g_search = madeURL(requestUrL);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(g_search);
        } catch (IOException e) {
        }
        List<News_ingredient> b_search = Datafromjson(jsonResponse);
        return (b_search);
    }

    private static String makeHttpRequest(URL g_search) throws IOException {
        String jsonResponse = null;
        if (g_search == null) {
            return jsonResponse;
        }
        HttpURLConnection connection = null;
        InputStream i_s = null;
        try {
            connection = (HttpURLConnection) g_search.openConnection();
            connection.setReadTimeout(14000);
            connection.setConnectTimeout(16000);
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                i_s = connection.getInputStream();
                jsonResponse = fetch_from_stream(i_s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (i_s != null) {
                i_s.close();
            }
        }
        return jsonResponse;
    }

    private static String fetch_from_stream(InputStream inputStream) throws IOException {
        StringBuilder builds = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader i_s_r = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(i_s_r);
            String read_line = reader.readLine();
            while (read_line != null) {
                builds.append(read_line);
                read_line = reader.readLine();
            }
        }
        return builds.toString();
    }

    private static List<News_ingredient> Datafromjson(String string1) {
        if (TextUtils.isEmpty(string1)) {
            return null;
        }
        List<News_ingredient> News_list = new ArrayList<>();
        try {
            JSONObject basefeature = new JSONObject(string1);
            JSONObject baseresponse = basefeature.getJSONObject("response");
            JSONArray baseresult1 = baseresponse.getJSONArray("results");
            for (int j = 0; j < baseresult1.length(); j++) {
                JSONObject current1 = baseresult1.getJSONObject(j);
                String type = current1.optString("sectionName");
                JSONObject fieldr = current1.getJSONObject("fields");
                String title = fieldr.optString("headline");
                String w_url = fieldr.optString("shortUrl");
                String img = "https://wwww.prozis.com/themes/prozis/imgs/no-image.jpg";
                if (fieldr.has("thumbnail")) {

                    img = fieldr.optString("thumbnail");
                }
                News_list.add(new News_ingredient(title, type, w_url, img));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return News_list;
    }

    private static URL madeURL(String fill_url) {
        URL find_url = null;
        try {
            find_url = new URL(fill_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return find_url;
    }
}
