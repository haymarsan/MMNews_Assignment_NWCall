package com.example.mmnewsassignment.data.models;


import com.example.mmnewsassignment.data.vos.CommentVO;
import com.example.mmnewsassignment.data.vos.FavoriteVO;
import com.example.mmnewsassignment.data.vos.NewsVO;
import com.example.mmnewsassignment.data.vos.SendToVO;

import java.util.List;

public interface NewsModel {

    void addCommentNews(NewsVO news, CommentVO comment);

    void favoriteNews(NewsVO news, FavoriteVO favorite);

    void sendNewsTo(NewsVO news, SendToVO sendTo);

    //Get News.
    List<NewsVO> getNews(NewsDelegate newsDelegate, boolean isForce);

    interface NewsDelegate {

        void onNewsFetchedFromNetwork(List<NewsVO> newsList);

        void onErrorNewsFetch(String msg);
    }
}
