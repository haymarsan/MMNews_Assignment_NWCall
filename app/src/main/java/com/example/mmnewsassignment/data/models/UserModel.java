package com.example.mmnewsassignment.data.models;


import com.example.mmnewsassignment.data.vos.UserVO;

public interface UserModel {



    UserVO loginUser( String phone, String password, UserLoginDelegate userLoginDelegate);

    UserVO registerUser(String name, String phone, String password, UserLoginDelegate userLoginDelegate);


    interface UserLoginDelegate {

        void onSuccess(UserVO userVO);

        void onError(String message);

    }


}
