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

    public static ArrayList<String> jsonStringToMovies(String jsonResponse){
        JSONObject rootJson, movieJsonObj;
        JSONArray jsonArray;
        String posterPath;
        ArrayList<String> movies = new ArrayList<String>();
        try{
            rootJson = new JSONObject(jsonResponse);
            jsonArray = rootJson.getJSONArray("results");
            for(int i=0; i < jsonArray.length(); i++) {
                movieJsonObj = jsonArray.getJSONObject(i);
                posterPath = movieJsonObj.getString("poster_path");
                movies.add(i,posterPath);
            }
        }
        catch (JSONException e){
            Log.e(LOG_TAG, "Problem converting to JSON array: " + e);
            e.printStackTrace();
        }
        Log.i(LOG_TAG, "The json object is: " + movies.toString());
        return movies;
    }

}
