package com.example.retrofitdemo2.api;

import com.example.retrofitdemo2.model.MyGit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApi {
@GET("/users/{user}/following")
Call<List<MyGit>> getMyGit(@Path("user")String user);
@GET("/users/{user}")
Call<MyGit> getMyGit2(@Path("user")String user);
}
