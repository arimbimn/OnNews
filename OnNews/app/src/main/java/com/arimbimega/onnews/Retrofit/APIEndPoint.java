package com.arimbimega.onnews.Retrofit;

import com.arimbimega.onnews.Model.EntModel;
import com.arimbimega.onnews.Model.HealthModel;
import com.arimbimega.onnews.Model.SportModel;
import com.arimbimega.onnews.Model.TechModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndPoint {

    @GET("top-headlines?country=id&category=health&apiKey=240840355b184816ac0f8dd6e46d591d")
    Call<HealthModel> getHealthModel();

    @GET("top-headlines?country=id&category=sport&apiKey=240840355b184816ac0f8dd6e46d591d")
    Call<SportModel> getSportModel();

    @GET("top-headlines?country=id&category=entertainment&apiKey=240840355b184816ac0f8dd6e46d591d")
    Call<EntModel> getEntModel();

    @GET("top-headlines?country=id&category=technology&apiKey=240840355b184816ac0f8dd6e46d591d")
    Call<TechModel> getTechModel();

}
