package com.example.retrofitapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitapplication.Adapter.CommentAdapter;
import com.example.retrofitapplication.Model.Comment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    JsonPlaceholder jsonPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholder = retrofit.create(JsonPlaceholder.class);
        // getpost();
        // getcomment();
        createPost();
    }

    private void createPost() {
        ItemModel itemModel = new ItemModel("18", "First Title", "First Text");
        Call<ItemModel> call = jsonPlaceholder.createPost(itemModel);
        call.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<ItemModel> itemModels = new ArrayList<>();
                itemModels.add(response.body());

                ItemAdapter itemAdapter=new ItemAdapter(MainActivity.this,itemModels);
                recyclerView.setAdapter(itemAdapter);
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getcomment() {
        Call<List<Comment>> call = jsonPlaceholder.getPostComment(2);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }
                List<Comment> postlist1 = response.body();
                CommentAdapter itemAdapter = new CommentAdapter(MainActivity.this, postlist1);
                recyclerView.setAdapter(itemAdapter);

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void getpost() {
//        Call<List<ItemModel>> call = jsonPlaceholder.getPost();
//        call.enqueue(new Callback<List<ItemModel>>() {
//            @Override
//            public void onResponse(Call<List<ItemModel>> call, Response<List<ItemModel>> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
//                }
//                List<ItemModel> postlist = response.body();
//                ItemAdapter itemAdapter=new ItemAdapter(MainActivity.this,postlist);
//                recyclerView.setAdapter(itemAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ItemModel>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}