package com.gunar.retro.retrofit.remote;

public class ApiUtils {
    public static final String BASE_URL = "https://reqres.in/";

    public static APIService getApiServices(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
