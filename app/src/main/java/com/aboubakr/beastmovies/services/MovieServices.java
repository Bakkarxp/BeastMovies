package com.aboubakr.beastmovies.services;


import com.aboubakr.beastmovies.entities.Movie;

import java.util.ArrayList;

// these class are the carriers of data to be passed using bus "Event argument classes"
public class MovieServices {
    // private to prevent creating an instance
    private MovieServices() {
    }

    // public static so any thing can access it
    public static class SearchMoviesRequest{
        public String query;

        public SearchMoviesRequest(String query) {
            this.query = query;
        }
    }


    public static class SearchMoviesResponse{
        public ArrayList<Movie> movies;

    }
}
