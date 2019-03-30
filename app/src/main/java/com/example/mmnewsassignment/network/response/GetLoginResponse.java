package com.example.mmnewsassignment.network.response;

import com.example.mmnewsassignment.data.vos.UserVO;
import com.google.gson.annotations.SerializedName;


public class GetLoginResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private UserVO loginVO;

    public UserVO getLoginVO() {
        return loginVO;
    }
}
