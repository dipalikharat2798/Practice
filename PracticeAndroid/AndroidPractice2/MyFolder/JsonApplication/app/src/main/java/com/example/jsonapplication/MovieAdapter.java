package com.example.jsonapplication;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context context;
    private List<MovieModel> movieList;

    public MovieAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item_layout,parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
      MovieModel movie = movieList.get(position);
      holder.rating.setText(movie.getRating()+"");
      holder.title.setText(movie.getTitle());
      holder.overview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPoster()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, overview, rating;
        CardView cardView;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.movie_img);
            title=itemView.findViewById(R.id.moviename_tv);
            overview=itemView.findViewById(R.id.overview_tv);
            rating=itemView.findViewById(R.id.rating_tv);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
