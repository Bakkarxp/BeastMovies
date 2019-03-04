package com.aboubakr.beastmovies.model;

import com.google.gson.annotations.SerializedName;

//this model used for json structure
public class MovieModel {

    @SerializedName("poster_path") // name used in json object
    String moviePosetr;

    @SerializedName("vote_average")
    double movieAverage;

    @SerializedName("title")
    String movieTitle;

    @SerializedName("overview")
    String movieSummary;

    @SerializedName("release_date")
    String movieReleaseDate;

    public MovieModel() {
    }

    public String getMoviePosetr() {
        return moviePosetr;
    }

    public double getMovieAverage() {
        return movieAverage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }
}
