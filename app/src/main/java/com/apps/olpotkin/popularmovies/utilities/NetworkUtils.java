package com.apps.olpotkin.popularmovies.utilities;


import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();
    private static final String MOVIE_URL = "http://api.themoviedb.org/3/movie";

    // API key to access http://api.themoviedb.org/
    private static final String API_KEY = "YOUR_API_KEY";

    final static String API_KEY_PARAM = "api_key";

    public static URL buildUrl(String categoryQuery) {
        Uri builtUri = Uri.parse(MOVIE_URL).buildUpon()
                .appendPath(categoryQuery)
                .appendQueryParameter(API_KEY_PARAM, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }
}
