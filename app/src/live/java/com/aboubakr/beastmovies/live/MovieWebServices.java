package com.aboubakr.beastmovies.live;

import com.aboubakr.beastmovies.model.ParentModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

// contains info about service i will connect to
public interface MovieWebServices {
    @GET("/3/movie/{parameter}")
    Call<ParentModel> loadMovies(
            @Path("parameter") String requestType,
            @Query("api_key") String APIKEY
    );
}
