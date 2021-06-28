package com.arimbimega.onnews.Retrofit;

import com.arimbimega.onnews.Model.HealthModel;
import com.arimbimega.onnews.Model.SportModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndPoint {

    @GET("top-headlines?country=id&category=health&apiKey=240840355b184816ac0f8dd6e46d591d")
    Call<HealthModel> getHealthModel();

    @GET("top-headlines?country=id&category=sport&apiKey=240840355b184816ac0f8dd6e46d591d")
    Call<SportModel> getSportModel();

}
