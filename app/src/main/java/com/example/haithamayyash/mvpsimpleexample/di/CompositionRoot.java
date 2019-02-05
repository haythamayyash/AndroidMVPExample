package com.example.haithamayyash.mvpsimpleexample.di;

import com.example.haithamayyash.mvpsimpleexample.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.haithamayyash.mvpsimpleexample.util.Constants.BASE_URL;

public class CompositionRoot {

    public Retrofit getRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public ApiInterface getApiInterface() {
        return getRetrofit().create(ApiInterface.class);
    }
}
