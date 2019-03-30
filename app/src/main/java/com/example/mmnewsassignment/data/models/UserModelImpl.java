package com.example.mmnewsassignment.data.models;


import com.example.mmnewsassignment.data.vos.UserVO;
import com.example.mmnewsassignment.delegates.LoginResponseDelegate;

public class UserModelImpl extends BaseModel implements UserModel {

    private static UserModelImpl userModelimpl;
    UserVO userVOInfo;


    private UserModelImpl() {
    }

    public static UserModelImpl getInstance() {
        if (userModelimpl == null) {
            userModelimpl = new UserModelImpl();
        }
        return userModelimpl;
    }


    @Override
    public UserVO loginUser(String phone, String password, final UserLoginDelegate userLoginDelegate) {

        newsDataAgent.login(phone, password, new LoginResponseDelegate() {
            @Override
            public void onSuccess(UserVO userVO) {
                userLoginDelegate.onSuccess(userVO);
                userVOInfo = userVO;
            }

            @Override
            public void onError(String message) {
                userLoginDelegate.onError(message);
            }
        });

        return userVOInfo;

    }


    @Override
    public UserVO registerUser(String name, String phone, String password, final UserLoginDelegate userLoginDelegate) {
        newsDataAgent.register(phone, name, password, new LoginResponseDelegate() {
            @Override
            public void onSuccess(UserVO userVO) {
                userLoginDelegate.onSuccess(userVO);
                userVOInfo = userVO;
            }

            @Override
            public void onError(String message) {
                userLoginDelegate.onError("Fail to register");
            }
        });
        return userVOInfo;
    }

    public UserVO getUserInfo() {
        return userVOInfo;
    }


}
