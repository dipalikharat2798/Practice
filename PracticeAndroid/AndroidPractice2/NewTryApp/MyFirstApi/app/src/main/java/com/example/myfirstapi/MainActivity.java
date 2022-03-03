package com.example.myfirstapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ApiInterface apiInterface;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface=RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView=findViewById(R.id.recycler);
        apiInterface.getposts().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {
                if (response.body().size()>0){
                    List<PostPojo> postList=response.body();
                    ApiAdapter adapter=new ApiAdapter(postList,MainActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "List is not empty", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}