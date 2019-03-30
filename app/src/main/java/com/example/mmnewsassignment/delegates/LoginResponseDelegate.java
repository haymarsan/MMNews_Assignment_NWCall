package com.example.mmnewsassignment.delegates;


import com.example.mmnewsassignment.data.vos.UserVO;

public interface LoginResponseDelegate {

    void onSuccess(UserVO userVO);

    void onError(String message);


}
