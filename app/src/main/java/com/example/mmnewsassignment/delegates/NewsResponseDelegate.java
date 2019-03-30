package com.example.mmnewsassignment.delegates;



import com.example.mmnewsassignment.data.vos.NewsVO;

import java.util.List;

public interface NewsResponseDelegate {

    void onSuccess(List<NewsVO> newsList);

    void onFail(String msg);
}
