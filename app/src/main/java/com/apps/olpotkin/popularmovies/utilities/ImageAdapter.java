package com.apps.olpotkin.popularmovies.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ImageAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context mContext;
    private String[] img;

    public ImageAdapter(Context c, String[] img) {
        mContext = c;
        this.img = img;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Create a new ImageView for each item referenced by adapter
    public View getView(int position, View view, ViewGroup parent) {
        ImageView posterImage;

        if (view == null) {
            // if it's not recycled, initialize attributes
            posterImage = new ImageView(mContext);
            posterImage.setLayoutParams(new GridView.LayoutParams(500, 780));
            posterImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            posterImage.setAdjustViewBounds(true);
            posterImage.setPadding(1,12,1,12);
        } else {
            posterImage = (ImageView) view;
        }

        Picasso.with(mContext).load(img[position]).into(posterImage);

        return posterImage;
    }

}
