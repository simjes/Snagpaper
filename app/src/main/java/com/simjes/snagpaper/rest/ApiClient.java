package com.simjes.snagpaper.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiEndpoints REST_CLIENT;
    private static final String API_URL = "https://api.imgur.com/";

    static {
        setupRestClient();
    }

    private ApiClient() {
    }

    public static ApiEndpoints get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        REST_CLIENT = retrofit.create(ApiEndpoints.class);
    }
}
