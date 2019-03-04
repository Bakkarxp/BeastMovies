package com.aboubakr.beastmovies.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aboubakr.beastmovies.R;
import com.aboubakr.beastmovies.entities.Movie;
import com.aboubakr.beastmovies.infrastructure.BeastMoviesApplication;
import com.aboubakr.beastmovies.services.MovieServices;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    //region view binding
    @BindView(R.id.activity_main_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.activity_main_movie_summery)
    TextView movieSummary;

    @BindView(R.id.activity_main_movie_vote)
    TextView movieVote;

    @BindView(R.id.activity_main_moviePicture)
    ImageView moviePicture;

    @BindView(R.id.activity_main_movieReleaseDate)
    TextView movieReleaseDate;

    @BindView(R.id.activity_main_movieTitle)
    TextView movieTitle;

    @BindView(R.id.activity_main_right_arrow)
    ImageView rightArrow;

    @BindView(R.id.activity_main_left_arrow)
    ImageView leftArrow;
    //endregion

    ArrayList<Movie> movies;

    int index;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        movies= new ArrayList<>();
        index = 0;
        bus.post(new MovieServices.SearchMoviesRequest("popular"));
        if (movies.size()!=0){
            UpdateUI(movies.get(index));
        }
    }

    private void UpdateUI(Movie movie){
        progressBar.setVisibility(View.VISIBLE);
        movieTitle.setText(movie.getMovieTitle());
        movieSummary.setText(movie.getMovieSummery());
        movieReleaseDate.setText(movie.getMovieRelease());
        movieVote.setText(Double.toString(movie.getMovieRating()));
        Log.i(MainActivity.class.getSimpleName(),movie.getMoviePicture());


        Picasso.get().load(movie.getMoviePicture())
                .into(moviePicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {


                    }
                });
    }


    @OnClick(R.id.activity_main_left_arrow)
    public void SetUpLeftArrow(){
        if(index == 0){
            Toast.makeText(this,"This is the end of movie list",Toast.LENGTH_SHORT).show();
        }else{
            index --;
            UpdateUI(movies.get(index));
        }

//        Toast.makeText(this,"Left Arrow",Toast.LENGTH_SHORT).show();
//        Log.i(MainActivity.class.getSimpleName(), "SetUpLeftArrow: ");
    }

    @OnClick(R.id.activity_main_right_arrow)
    public void SetUpRightArrow(){
        if(index == movies.size()-1){
            Toast.makeText(this,"This is the end of movie list",Toast.LENGTH_SHORT).show();
        }else{
            index ++;
            UpdateUI(movies.get(index));
        }


//        Toast.makeText(this,"Right Arrow",Toast.LENGTH_SHORT).show();
//        Log.i(MainActivity.class.getSimpleName(), "SetUpRightArrow: ");
    }



    @Subscribe
    public void getMovieMessage(MovieServices.SearchMoviesResponse response){
        movies.clear();
        movies.addAll(response.movies);
    }
}
