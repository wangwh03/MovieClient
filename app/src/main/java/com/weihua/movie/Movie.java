package com.weihua.movie;

import java.io.Serializable;

public class Movie implements Serializable {
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String backdropImagePath;
    private String fullBackdropImagePath;
    private double voteAverage;

    public Movie(String originalTitle, String overview, String posterPath, String backdropImagePath, String fullBackdropImagePath, double voteAverage) {
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropImagePath = backdropImagePath;
        this.fullBackdropImagePath = fullBackdropImagePath;
        this.voteAverage = voteAverage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropImagePath() {
        return backdropImagePath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getFullBackdropImagePath() {
        return fullBackdropImagePath;
    }
}
