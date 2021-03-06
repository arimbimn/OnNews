package com.arimbimega.onnews.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TechModel {

    @SerializedName("articles")
    private ArrayList<Articles> articlesArrayList;

    public ArrayList<Articles> getArticlesArrayList() {
        return articlesArrayList;
    }

    public void setArticlesArrayList(ArrayList<Articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }
}
