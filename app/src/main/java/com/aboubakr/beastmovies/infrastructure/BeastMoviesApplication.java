package com.aboubakr.beastmovies.infrastructure;

import android.app.Application;

import com.squareup.otto.Bus;

import com.aboubakr.beastmovies.live.Module;

// Otto is an event bus designed to decouple different parts of your application
// while still allowing them to communicate efficiently.
// we will use bus here pass data between components "here data comes from the server"

public class BeastMoviesApplication extends Application {
    private Bus bus;
    public static final String API_KEY = "b4df32edc5a9f5533c8d8ec3e259371f";
    public static final String BASE_URL = "https://api.themoviedb.org";
    public static final String BASE_PICTURE_URL = "https://image.tmdb.org/t/p/w185";

    // singleton
    public BeastMoviesApplication() {
            bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }
}
