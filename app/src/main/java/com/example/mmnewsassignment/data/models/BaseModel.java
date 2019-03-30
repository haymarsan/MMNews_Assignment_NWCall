package com.example.mmnewsassignment.data.models;

import com.example.mmnewsassignment.network.NewsDataAgent;
import com.example.mmnewsassignment.network.RetrofitDA;

public abstract class BaseModel {

    NewsDataAgent newsDataAgent;

    BaseModel() {
        newsDataAgent = RetrofitDA.getInstance();
    }

}
