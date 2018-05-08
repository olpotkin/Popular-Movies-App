package com.apps.olpotkin.popularmovies.model;


import org.json.JSONException;
import org.json.JSONObject;

public class Trailer {

    private String trailerId;
    private String trailerKey;
    private String trailerName;
    private String trailerSite;
    private String trailerType;

    // Constructor
    public Trailer() {

    }

    // Constructor with parameter
    public Trailer(JSONObject trailer) throws JSONException {
        this.trailerId = trailer.getString("id");
        this.trailerKey = trailer.getString("key");
        this.trailerName = trailer.getString("name");
        this.trailerSite = trailer.getString("site");
        this.trailerType = trailer.getString("type");
    }

    // Getter methods
    public String getId() { return trailerId; }

    public String getKey() { return trailerKey; }

    public String getName() { return trailerName; }

    public String getSite() { return trailerSite; }

    public String getType() { return trailerType; }
}
