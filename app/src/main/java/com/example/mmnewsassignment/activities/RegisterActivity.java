package com.example.mmnewsassignment.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mmnewsassignment.R;
import com.example.mmnewsassignment.data.models.UserModel;
import com.example.mmnewsassignment.data.models.UserModelImpl;
import com.example.mmnewsassignment.data.vos.UserVO;


public class RegisterActivity extends BaseActivity {
    TextView tvSignIn;
    String name, phone, password;
    UserModelImpl userModel;
    TextInputEditText txpName,txpPhone,txpPassword;
    Button btnRegister;

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        tvSignIn = findViewById(R.id.tv_sign_in);
        userModel = UserModelImpl.getInstance();
        btnRegister = findViewById(R.id.btn_register);

        txpName = findViewById(R.id.txedt_user_name);
        txpPassword = findViewById(R.id.txedt_user_password);
        txpPhone = findViewById(R.id.txedt_user_phone);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txpName.getText().toString();
                phone = txpPhone.getText().toString();
                password = txpPassword.getText().toString();
                register(name,phone,password);
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newIntent(RegisterActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void register(String name, String phone, String password) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();

        userModel.registerUser(name, phone, password, new UserModel.UserLoginDelegate() {
            @Override
            public void onSuccess(UserVO userVO) {
                Intent intent = MainActivity.newIntent(getApplicationContext());
                startActivity(intent);
                finish();
                progressDialog.cancel();
            }

            @Override
            public void onError(String message) {
                progressDialog.cancel();
            }
        });

    }
}
