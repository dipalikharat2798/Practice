package com.example.retrofitapplication;

import com.example.retrofitapplication.Model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceholder {
    @GET("posts")
    Call<List<ItemModel>> getPost();

    @GET("comments")
    Call<List<Comment>> getPostComment(@Query("postId") int postId);

    @POST("posts")
    Call<ItemModel> createPost(@Body ItemModel itemModel);
}
