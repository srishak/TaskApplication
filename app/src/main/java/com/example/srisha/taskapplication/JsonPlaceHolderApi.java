package com.example.srisha.taskapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderApi {

    String BASE_URL = "https://stark-spire-93433.herokuapp.com/";

    @GET("json")
    Call<Post> getPosts();
}
