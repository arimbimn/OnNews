package com.arimbimega.onnews.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class HealthModel {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private String totalResult;

    @SerializedName("articles")
    private ArrayList<Articles> articlesArrayList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<Articles> getArticlesArrayList() {
        return articlesArrayList;
    }

    public void setArticlesArrayList(ArrayList<Articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }
}
