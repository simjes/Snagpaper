package com.simjes.snagpaper.rest;

import com.simjes.snagpaper.models.ImgurResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ApiEndpoints {
    @GET("3/gallery/t/wallpaper/time/{page}")
    Call<ImgurResponse> getPictures(@Header("Authorization") String clientId, @Path("page") int page);
}
