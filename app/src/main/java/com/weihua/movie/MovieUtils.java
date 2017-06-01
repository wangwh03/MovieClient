package com.weihua.movie;

public class MovieUtils {
    private static final int POPULAR_THRESHOLD = 6;

    public static boolean isPopular(Movie movie) {
        return movie.getVoteAverage() > POPULAR_THRESHOLD;
    }
}
