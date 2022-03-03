package com.example.jsonapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {
    private static final String TAG = "MovieActivity";
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    List<MovieModel> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        recyclerView = findViewById(R.id.movie_recycler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue=VolleySingletone.getInstance(this).getRequestQueue();
        movieList = new ArrayList<>();
        fetchMovies();
    }

    private void fetchMovies() {
        String url = "http://www.json-generator.com/api/json/get/cfThbAydvm?indent=2";

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String overview = jsonObject.getString("overview");
                        String poster = jsonObject.getString("poster");
                        double rating = jsonObject.getDouble("rating");

                        MovieModel movieModel=new MovieModel(title,poster,overview,rating);
                        movieList.add(movieModel);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MovieAdapter adapter = new MovieAdapter(MovieActivity.this,movieList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MovieActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}