package com.apps.olpotkin.popularmovies.utilities;

import com.apps.olpotkin.popularmovies.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtils {

    public static Movie[] getAllMoviesFromJson(String movieJsonStr)
            throws JSONException {

        final String TITLE = "title";
        final String OVERVIEW = "overview";
        final String POSTER_PATH = "poster_path";
        final String RELEASE_DATE = "release_date";
        final String VOTE_AVERAGE = "vote_average";

        Movie[] movieData = null;

        JSONObject movieJson = new JSONObject(movieJsonStr);
        JSONArray movieArray = movieJson.getJSONArray("results");

        movieData = new Movie[movieArray.length()];

        for (int i = 0; i < movieArray.length(); i++) {
            JSONObject movie_sample = movieArray.getJSONObject(i);

            String title = movie_sample.getString(TITLE);
            String overview = movie_sample.getString(OVERVIEW);
            String poster_full_path = movie_sample.getString(POSTER_PATH);
            String release_date = movie_sample.getString(RELEASE_DATE);
            String vote_average = movie_sample.getString(VOTE_AVERAGE);

            movieData[i] = new Movie(
                    title,
                    overview,
                    poster_full_path,
                    release_date,
                    vote_average);
        }

        return movieData;
    }
}
