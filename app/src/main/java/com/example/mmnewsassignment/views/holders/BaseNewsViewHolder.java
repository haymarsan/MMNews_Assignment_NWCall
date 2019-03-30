package com.example.mmnewsassignment.views.holders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mmnewsassignment.R;
import com.example.mmnewsassignment.data.vos.NewsVO;


import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseNewsViewHolder extends BaseViewHolder<NewsVO> {

    @BindView(R.id.tv_brief_news)
    TextView tvBriefNews;

    @BindView(R.id.iv_news_hero_image)
    ImageView ivNewsHeroImage;

//    @Nullable
//    @BindView(R.id.tv_published_date)
//    TextView tvPublished_date;




    public BaseNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(NewsVO data) {
        tvBriefNews.setText(data.getBrief());
       // tvPublished_date.setText(data.getPostedDate());

        if(ivNewsHeroImage != null) {
            Glide.with(itemView)
                    .load(data.getHeroImage())
                    .into(ivNewsHeroImage);
        }
    }
}
