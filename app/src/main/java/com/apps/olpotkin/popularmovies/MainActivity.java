package com.apps.olpotkin.popularmovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import com.apps.olpotkin.popularmovies.model.Movie;
import com.apps.olpotkin.popularmovies.utilities.JsonUtils;
import com.apps.olpotkin.popularmovies.utilities.NetworkUtils;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    String active_category = "popular";                 // Default Active category

    // Store parsed data
    Movie[] movie_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        processGridView(active_category);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_mostpopular:
                active_category = "popular";
                processGridView(active_category);
                return true;
            case R.id.option_highestrated:
                active_category = "top_rated";
                processGridView(active_category);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void processGridView(String category) {
        active_category = category;
        new FetchMovieTask().execute(category);
    }

    private void RefreshGrid()
    {
        // Get paths to images
        String[] imgUrls = new String[movie_db.length];
        for (int i = 0; i < imgUrls.length; i++){
            imgUrls[i] = movie_db[i].getPosterPath();
        }
        GridView gridview = (GridView) findViewById(R.id.main_grid);
        gridview.setAdapter(new ImageAdapter(this, imgUrls));
    }


    public class FetchMovieTask extends AsyncTask<String, Void, Movie[]> {

        @Override
        protected Movie[] doInBackground(String... params) {

            /* If there's no movie category, there's nothing to look up. */
            if (params.length == 0) {
                return null;
            }

            String category = params[0];
            URL movieRequestUrl = NetworkUtils.buildUrl(category);

            try {
                String jsonMovieResponse = NetworkUtils
                        .getResponseFromHttpUrl(movieRequestUrl);
                Log.v("MainActivity", "Built URI " + jsonMovieResponse);

                Movie[] movieData = JsonUtils
                        .getAllMoviesFromJson(jsonMovieResponse);

                return movieData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Movie[] movieData) {
            if (movieData != null) {

                // Update movie data
                movie_db = movieData;

                // Visualization
                RefreshGrid();
            }
        }
    }

}
