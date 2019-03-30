package com.example.mmnewsassignment.network;


import com.example.mmnewsassignment.delegates.LoginResponseDelegate;
import com.example.mmnewsassignment.delegates.NewsResponseDelegate;

public interface NewsDataAgent {

    String MMNEWS_BASE_URL = "http://padcmyanmar.com/padc-3/mm-news/apis/";

    String GET_NEWS = "v1/getMMNews.php";

    String PARAM_ACCESS_TOKEN = "access_token";
    String PARAM_PAGE = "page";

    void loadNews(int page, String accessToken,
                  NewsResponseDelegate newsResponseDelegate);

    void login(String phoneNo, String pasword, LoginResponseDelegate loginResponseDelegate);

    void register(String phoneNo, String name, String password,LoginResponseDelegate loginResponseDelegate);
}
