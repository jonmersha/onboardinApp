package com.hira.cooponboarding;


import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private Retrofit retrofit;
    @Override
    public void onCreate() {
        super.onCreate();
        retrofit=new Retrofit.Builder()
                .baseUrl("http://10.1.110.99:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public Retrofit getRetrofit() {
        return retrofit;
    }
    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}

