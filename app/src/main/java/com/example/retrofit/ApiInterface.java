package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("everything?q=tesla&from=2022-02-27&sortBy=publishedAt&apiKey=0270d24f29c543b7b01c3357e4782d22")
    Call<Example> getExamples();
}
