package com.fouadbahari.allinone.data;

import com.fouadbahari.allinone.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostModel>> getPosts();

}
