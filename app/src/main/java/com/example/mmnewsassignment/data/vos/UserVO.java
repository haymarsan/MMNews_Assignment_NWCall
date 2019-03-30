package com.example.mmnewsassignment.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserVO {

    @SerializedName("userId")
    private String userId;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("phoneNo")
    private String phoneNo;

    @SerializedName("profileUrl")
    private String profileUrl;

    @SerializedName("coverUrl")
    private String coverUrl;


    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }
}


//        userId": 6,
//        "name": "Phyo Phone Myint",
//        "email": "phyophonemyint.dw2@gmail.com",
//        "phoneNo": "+959783499912",
//        "profileUrl": "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAArwAAAAJDY3ZWI0ZTljLWI5OGItNDYwMC1hYzliLTA4Nzc5OGFmNWJjZQ.jpg",
//        "coverUrl":

