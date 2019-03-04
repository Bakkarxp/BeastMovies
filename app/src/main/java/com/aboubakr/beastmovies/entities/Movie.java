package com.aboubakr.beastmovies.entities;

// this model used for android
public class Movie {
    private String movieTitle;
    private String movieSummery;
    private String moviePicture;
    private String movieRelease;
    private double movieRating;

    public Movie(String movieTitle, String movieSummery, String moviePicture, String movieRelease, double movieRating) {
        this.movieTitle = movieTitle;
        this.movieSummery = movieSummery;
        this.moviePicture = moviePicture;
        this.movieRelease = movieRelease;
        this.movieRating = movieRating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieSummery() {
        return movieSummery;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public double getMovieRating() {
        return movieRating;
    }
}
