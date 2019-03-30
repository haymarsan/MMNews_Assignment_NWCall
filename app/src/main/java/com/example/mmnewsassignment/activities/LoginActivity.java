package com.example.mmnewsassignment.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mmnewsassignment.R;
import com.example.mmnewsassignment.data.models.UserModel;
import com.example.mmnewsassignment.data.models.UserModelImpl;
import com.example.mmnewsassignment.data.vos.UserVO;

public class LoginActivity extends BaseActivity {

    TextInputEditText edtUserPhone, edtUserPassword;
    UserModelImpl userModel;
    Button btnLogin;
    String userName, password;
    TextView tvSignUp;

    public static Intent newIntent(Context context){
        return new Intent(context,LoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        edtUserPhone = findViewById(R.id.txedt_user_phone);
        edtUserPassword = findViewById(R.id.txedt_user_password);
        btnLogin = findViewById(R.id.btn_login);
        tvSignUp = findViewById(R.id.tv_sign_up);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RegisterActivity.newIntent(LoginActivity.this);
                startActivity(intent);
                finish();
            }
        });

        userModel = UserModelImpl.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(LoginActivity.this,"phone : "+userName,Toast.LENGTH_LONG).show();

                userName = edtUserPhone.getText().toString();
                password = edtUserPassword.getText().toString();

                if(!userName.equals("") && !password.equals(""))
                    setUpLogin(userName, password);
                else {
                    if(userName.equals("")) edtUserPhone.setError("Phone require");
                    if(password.equals("")) edtUserPassword.setError("Password require");
                }
                }

        });


    }

    private void setUpLogin(String phone, String password) {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setTitle("Loading ... ");

            userModel.loginUser(phone, password, new UserModel.UserLoginDelegate() {

                @Override
                public void onSuccess(UserVO userVO) {
                    Log.d("Email : ", userVO.getEmail() + getClass().getName());
                    Log.d("Phone : ", userVO.getPhoneNo()+ getClass().getName());
                    Log.d("User Id : ", userVO.getUserId() + ""+ getClass().getName());
                    Intent intent = MainActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                    finish();
                    progressDialog.cancel();
                }

                @Override
                public void onError(String message) {
                    edtUserPhone.setError("Login Fail");
                    edtUserPassword.setError("Login Fail");
                    progressDialog.cancel();

                }
            });


    }
}
