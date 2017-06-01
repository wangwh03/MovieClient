package com.weihua.movie;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieFactory {

    private static final String POSTER_PATH_PREFIX = "https://image.tmdb.org/t/p/w500/";
    private static final String FULL_IMAGE_PATH_PREFIX = "https://image.tmdb.org/t/p/w1280/";

    public static ArrayList<Movie> createMovies(JSONObject response) throws JSONException {
        JSONArray moviesJson = response.getJSONArray("results");
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < moviesJson.length(); i++) {
            movies.add(createMovie(moviesJson.getJSONObject(i)));
        }
        return movies;
    }

    private static Movie createMovie(JSONObject movieJson) throws JSONException {
        return new Movie(movieJson.getString("original_title"),
                         movieJson.getString("overview"),
                         createImagePath("poster_path", movieJson),
                         createImagePath("backdrop_path", movieJson),
                         createFullImagePath("backdrop_path", movieJson),
                         movieJson.getDouble("vote_average"));
    }

    private static String createFullImagePath(String imageName, JSONObject movieJson) throws JSONException {
        return new StringBuilder(FULL_IMAGE_PATH_PREFIX)
            .append(movieJson.getString(imageName))
            .toString();
    }

    private static String createImagePath(String imageName, JSONObject movieJson) throws JSONException {
        return new StringBuilder(POSTER_PATH_PREFIX)
            .append(movieJson.getString(imageName))
            .toString();
    }
}
