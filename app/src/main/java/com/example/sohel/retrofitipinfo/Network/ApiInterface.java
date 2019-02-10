package com.example.sohel.retrofitipinfo.Network;

import com.example.sohel.retrofitipinfo.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/json") //here, 'json' is the Path parameter
    Call<ServerResponse>getMyIp();
}
