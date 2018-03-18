package com.apps.olpotkin.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MovieDetailsActivity extends AppCompatActivity {

    String POSTER_W780_PATH = "http://image.tmdb.org/t/p/w780/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup Layout
        setContentView(R.layout.content_movie_details);

        if (!LoadUI()) {
            Log.d("*** Error, LoadUI()", "Error occurs while LoadUI()");
        }
    }

    private boolean LoadUI() {
        ImageView iv_poster = (ImageView) findViewById(R.id.iv_poster);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        TextView tv_overview = (TextView) findViewById(R.id.tv_overview);
        TextView tv_release_date = (TextView) findViewById(R.id.tv_release_date);
        TextView tv_vote_avg = (TextView) findViewById(R.id.tv_vote_avg);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            if (extras.containsKey("poster_path")
                    && extras.containsKey("title")
                    && extras.containsKey("overview")
                    && extras.containsKey("release_date")
                    && extras.containsKey("vote_avg")) {

                String poster_high_res = POSTER_W780_PATH +
                        intent.getStringExtra("poster_path");

                Picasso.with(this).load(poster_high_res).into(iv_poster);
                tv_title.setText(intent.getStringExtra("title"));
                tv_overview.setText(intent.getStringExtra("overview"));
                tv_release_date.setText("Release date: " + intent.getStringExtra("release_date"));
                tv_vote_avg.setText("Rating: " + intent.getStringExtra("vote_avg"));
            } else
                return false;
        } else
            return false;

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
