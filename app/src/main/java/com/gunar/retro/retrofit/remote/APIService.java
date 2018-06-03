package com.gunar.retro.retrofit.remote;

import com.gunar.retro.retrofit.model.LoginE;
import com.gunar.retro.retrofit.model.LoginR;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("api/users")
    Call<LoginR> llamar(@Body LoginE r);

}
