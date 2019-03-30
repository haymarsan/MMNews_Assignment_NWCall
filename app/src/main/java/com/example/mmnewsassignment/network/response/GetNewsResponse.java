package com.example.mmnewsassignment.network.response;

import com.example.mmnewsassignment.data.vos.NewsVO;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class GetNewsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("mmNews")
    private List<NewsVO> newsList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }

    public boolean isResponseSuccess() {
        return code == 200;
    }
}
