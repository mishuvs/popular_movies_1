package com.mishu.vaibhav.popmoviesone.popularmoviesone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vaibhav on 11/24/2017.
 * RecyclerView Adapter for movies
 */

public class MovieAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class MovieHolder extends RecyclerView.ViewHolder{

        MovieHolder(View itemView) {
            super(itemView);
        }

    }
}
