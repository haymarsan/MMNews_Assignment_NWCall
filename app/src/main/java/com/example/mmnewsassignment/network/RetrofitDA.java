package com.example.mmnewsassignment.network;


import android.util.Log;

import com.example.mmnewsassignment.delegates.LoginResponseDelegate;
import com.example.mmnewsassignment.delegates.NewsResponseDelegate;
import com.example.mmnewsassignment.network.response.GetLoginResponse;
import com.example.mmnewsassignment.network.response.GetNewsResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements NewsDataAgent {

    private static RetrofitDA objInstance;

    private NewsAPI mNewsAPI;

    private RetrofitDA() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mNewsAPI = retrofit.create(NewsAPI.class);
    }

    public static RetrofitDA getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDA();
        }
        return objInstance;
    }

    @Override
    public void loadNews(int page, String accessToken, final NewsResponseDelegate newsResponseDelegate) {
        Call<GetNewsResponse> callNewsResponse = mNewsAPI.loadNews(accessToken, page);
        callNewsResponse.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse newsResponse = response.body();
                if (newsResponse != null) {
                    if (newsResponse.isResponseSuccess()) {
                        newsResponseDelegate.onSuccess(newsResponse.getNewsList());
                    } else {
                        newsResponseDelegate.onFail(newsResponse.getMessage());
                    }
                } else {
                    newsResponseDelegate.onFail("Response is null.");
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                newsResponseDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void login(String phoneNumber, String password, final LoginResponseDelegate loginResponseDelegate) {
        Call<GetLoginResponse> loginResponseCall = mNewsAPI.loginUser(phoneNumber, password);
        loginResponseCall.enqueue(new Callback<GetLoginResponse>() {
            @Override
            public void onResponse(Call<GetLoginResponse> call, Response<GetLoginResponse> response) {

                Log.d("Retrofit", "Success");


                GetLoginResponse loginResponse = response.body();
                loginResponseDelegate.onSuccess(loginResponse.getLoginVO());

            }

            @Override
            public void onFailure(Call<GetLoginResponse> call, Throwable t) {
                loginResponseDelegate.onError("Fail to login");
                Log.d("Retrofit", " Fail");

            }
        });

    }

    @Override
    public void register(String phoneNUmber, String name, String password, final LoginResponseDelegate loginResponseDelegate) {
        Call<GetLoginResponse> loginResponseCall = mNewsAPI.registerUser(name, phoneNUmber, password);
        loginResponseCall.enqueue(new Callback<GetLoginResponse>() {
            @Override
            public void onResponse(Call<GetLoginResponse> call, Response<GetLoginResponse> response) {
                GetLoginResponse getLoginResponse = response.body();
                loginResponseDelegate.onSuccess(getLoginResponse.getLoginVO());
            }

            @Override
            public void onFailure(Call<GetLoginResponse> call, Throwable t) {
                loginResponseDelegate.onError("Register Fail");
            }
        });
    }
}
