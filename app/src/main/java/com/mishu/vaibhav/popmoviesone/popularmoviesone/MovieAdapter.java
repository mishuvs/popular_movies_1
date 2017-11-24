package com.mishu.vaibhav.popmoviesone.popularmoviesone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Network;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mishu.vaibhav.popmoviesone.popularmoviesone.utils.NetworkUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Vaibhav on 11/24/2017.
 * RecyclerView Adapter for movies
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    private ArrayList<String> posterUrls;
    private Context context;

    MovieAdapter(Context mContext, ArrayList<String> moviePosterUrls){
        posterUrls = moviePosterUrls;
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

        String url = NetworkUtils.BASE_IMAGE_URL + posterUrls.get(position);
        Log.i(LOG_TAG,url);
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.small_icon)
                .fit()
                .into(holder.poster);

    }

    @Override
    public int getItemCount() {
        int count;
        if(posterUrls==null) count=0;
        else count = posterUrls.size();
        Log.i(LOG_TAG,"count: " + count);
        return count;
    }

    void swap(ArrayList<String> newUrls)
    {
        if(newUrls!=null && newUrls.size()>0){
            Log.i(LOG_TAG,"list swapped");
            posterUrls = newUrls;
            notifyDataSetChanged();
        }
    }

    class MovieHolder extends RecyclerView.ViewHolder{

        private final ImageView poster;

        MovieHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movie_image);
        }

    }
}
