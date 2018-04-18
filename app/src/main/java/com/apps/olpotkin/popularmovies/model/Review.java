package com.apps.olpotkin.popularmovies.model;


import org.json.JSONException;
import org.json.JSONObject;

public class Review {

    private String reviewId;
    private String reviewAuthor;
    private String reviewContent;

    // Constructor
    public Review() {

    }

    // Constructor with parameter
    public Review(JSONObject review) throws JSONException {
        this.reviewId = review.getString("id");
        this.reviewAuthor = review.getString("author");
        this.reviewContent = review.getString("content");
    }

    public String getReviewId() {
        return reviewId;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public String getReviewContent() {
        return reviewContent;
    }
}
