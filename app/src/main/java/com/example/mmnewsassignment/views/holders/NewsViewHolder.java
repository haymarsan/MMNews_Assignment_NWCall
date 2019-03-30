package com.example.mmnewsassignment.views.holders;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.mmnewsassignment.delegates.NewsItemDelegate;


public class NewsViewHolder extends BaseNewsViewHolder {

    private NewsItemDelegate mDelegate;

    public NewsViewHolder(@NonNull View itemView, @NonNull NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapNewsItem();
            }
        });
    }
}
