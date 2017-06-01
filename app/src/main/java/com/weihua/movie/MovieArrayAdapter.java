package com.weihua.movie;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

import static com.weihua.movie.MovieUtils.isPopular;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public int getItemViewType(int position) {
        if (isPopular(getItem(position))) {
            return MoviePopularity.POPULAR.ordinal();
        } else {
            return MoviePopularity.REGULAR.ordinal();
        }
    }

    @Override
    public int getViewTypeCount() {
        return MoviePopularity.values().length;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if (getItemViewType(position) == MoviePopularity.POPULAR.ordinal()) {
            PopularMovieItemViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie_popular, parent, false);
                viewHolder = new PopularMovieItemViewHolder((ImageView) convertView.findViewById(R.id.full_backdrop));
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (PopularMovieItemViewHolder) convertView.getTag();
            }

            ImageView backdropImageView = viewHolder.backdropImageView;
            backdropImageView.setImageResource(0);
            Picasso.with(getContext()).load(movie.getFullBackdropImagePath()).placeholder(R.drawable.ic_placeholder_image_poster).into(backdropImageView);
        } else {
            MovieItemViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
                viewHolder = new MovieItemViewHolder((ImageView) convertView.findViewById(R.id.poster),
                                                     (TextView) convertView.findViewById(R.id.title),
                                                     (TextView) convertView.findViewById(R.id.overview));
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (MovieItemViewHolder) convertView.getTag();
            }

            ImageView posterImageView = viewHolder.posterImageView;
            posterImageView.setImageResource(0);
            int orientation = getContext().getResources().getConfiguration().orientation;
            Picasso.with(getContext()).load(getImageUrl(orientation, movie)).placeholder(R.drawable.ic_placeholder_image_poster).into(posterImageView);

            viewHolder.titleTextView.setText(movie.getOriginalTitle());
            viewHolder.overviewTextView.setText(movie.getOverview());
        }

        return convertView;
    }

    private String getImageUrl(int orientation, Movie movie) {
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            return movie.getBackdropImagePath();
        } else {
            return movie.getPosterPath();
        }
    }

    private static class MovieItemViewHolder {
        ImageView posterImageView;
        TextView titleTextView;
        TextView overviewTextView;

        public MovieItemViewHolder(ImageView posterImageView, TextView titleTextView, TextView overviewTextView) {
            this.posterImageView = posterImageView;
            this.titleTextView = titleTextView;
            this.overviewTextView = overviewTextView;
        }
    }

    private static class PopularMovieItemViewHolder {
        ImageView backdropImageView;

        public PopularMovieItemViewHolder(ImageView backdropImageView) {
            this.backdropImageView = backdropImageView;
        }
    }
}
