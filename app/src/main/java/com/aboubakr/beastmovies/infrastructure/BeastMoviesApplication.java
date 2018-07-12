package com.aboubakr.beastmovies.infrastructure;

import android.app.Application;

import com.squareup.otto.Bus;

import aboubakr.beastmovies.inmemory.Module;


// Otto is an event bus designed to decouple different parts of your application
// while still allowing them to communicate efficiently.

public class BeastMoviesApplication extends Application {
    private Bus bus;

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
