package com.mishu.vaibhav.popmoviesone.popularmoviesone.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaibhav on 11/24/2017.
 */

public class MovieDbJsonUtils {

    private static final String LOG_TAG = MovieDbJsonUtils.class.getSimpleName();

    public static ArrayList<Movie> jsonStringToMovies(String jsonResponse){
        JSONObject rootJson, movieJsonObj;
        JSONArray jsonArray;
        String movieTitle;
        String movieUrlThumbnail;
        String movieOverview;
        double movieVoteAverage;
        String movieReleaseDate;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try{
            rootJson = new JSONObject(jsonResponse);
            jsonArray = rootJson.getJSONArray("results");
            for(int i=0; i < jsonArray.length(); i++) {
                movieJsonObj = jsonArray.getJSONObject(i);
                movieOverview = movieJsonObj.getString("overview");
                movieVoteAverage = movieJsonObj.getDouble("vote_average");
                movieTitle = movieJsonObj.getString("title");
                movieUrlThumbnail = movieJsonObj.getString("poster_path");
                movieReleaseDate = movieJsonObj.getString("release_date");
                movies.add(i, new Movie(movieTitle,movieUrlThumbnail,movieOverview,movieVoteAverage,movieReleaseDate));
            }
        }
        catch (JSONException e){
            Log.e(LOG_TAG, "Problem converting to JSON array: " + e);
            e.printStackTrace();
        }
        Log.i(LOG_TAG, "The json object is: " + movies.toString());
        return movies;
    }

    public static class Movie{
        public String movieTitle;
        public String movieUrlThumbnail;
        public String movieOverview;
        public double movieVoteAverage;
        public String movieReleaseDate;

        Movie(String title, String urlThumbnail, String overview, double voteAverage, String releaseDate)
        {
            movieTitle = title;
            movieUrlThumbnail = urlThumbnail;
            movieOverview = overview;
            movieVoteAverage = voteAverage;
            movieReleaseDate = releaseDate;
        }
    }

}
