package com.mishu.vaibhav.popmoviesone.popularmoviesone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieAdapter adapter = new MovieAdapter();
        GridLayoutManager movieLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        RecyclerView movieRecyclerView = findViewById(R.id.movie_recycler_view);
        movieRecyclerView.setAdapter(adapter);
        movieRecyclerView.setLayoutManager(movieLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sort_popular:
                //popular sort chosen
                break;

            case R.id.sort_rating:
                //rating sort chosen
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
