package com.aboubakr.beastmovies.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aboubakr.beastmovies.infrastructure.BeastMoviesApplication;
import com.squareup.otto.Bus;
// the aim of the base activity is to register the bus to be available in all child activities
public class BaseActivity extends AppCompatActivity {
    protected BeastMoviesApplication appliction;
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the application to get the bus from it
        appliction = (BeastMoviesApplication) getApplication();
        bus = appliction.getBus();
        // register bus
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // unregister the bus
        bus.unregister(this);
    }
}