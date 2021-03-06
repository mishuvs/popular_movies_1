package com.mishu.vaibhav.popmoviesone.popularmoviesone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mishu.vaibhav.popmoviesone.popularmoviesone.utils.MovieDbJsonUtils;
import com.mishu.vaibhav.popmoviesone.popularmoviesone.utils.NetworkUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Vaibhav on 11/24/2017.
 * RecyclerView Adapter for movies
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    private List<MovieDbJsonUtils.Movie> movies;
    private Context context;

    MovieAdapter(Context mContext, List<MovieDbJsonUtils.Movie> moviePosterUrls){
        movies = moviePosterUrls;
        context = mContext;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {

        Log.i(LOG_TAG,"insidebindview: " + position);

        MovieDbJsonUtils.Movie movie = movies.get(position);

        holder.movieUrlThumbnail = movie.movieUrlThumbnail;
        holder.movieTitle = movie.movieTitle;
        holder.movieOverview = movie.movieOverview;
        holder.movieVoteAverage = movie.movieVoteAverage;
        holder.movieReleaseDate = movie.movieReleaseDate;

        String url = NetworkUtils.BASE_IMAGE_URL + holder.movieUrlThumbnail;
        Log.i(LOG_TAG,url);
        Picasso.with(context)
                .load(url)
                .fit()
                .into(holder.poster);

    }

    @Override
    public int getItemCount() {
        int count;
        if(movies==null) count=0;
        else count = movies.size();
        Log.i(LOG_TAG,"count: " + count);
        return count;
    }

    void swap(List<MovieDbJsonUtils.Movie> newUrls)
    {
        if(newUrls!=null && newUrls.size()>0){
            Log.i(LOG_TAG,"list swapped");
            movies = newUrls;
            notifyDataSetChanged();
        }
    }

    class MovieHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        private final ImageView poster;
        String movieTitle;
        String movieUrlThumbnail;
        String movieOverview;
        double movieVoteAverage;
        String movieReleaseDate;

        MovieHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movie_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context,DetailActivity.class);
            i.putExtra("title",movieTitle);
            i.putExtra("url_thumbnail",movieUrlThumbnail);
            i.putExtra("overview",movieOverview);
            i.putExtra("vote_average",movieVoteAverage);
            i.putExtra("release_date",movieReleaseDate);
            context.startActivity(i);
        }
    }
}
