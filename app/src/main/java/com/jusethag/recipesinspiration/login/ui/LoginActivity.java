package com.jusethag.recipesinspiration.login.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jusethag.recipesinspiration.R;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity implements LoginView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void enableInputs() {

    }

    @Override
    public void disableInputs() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void handleLogin() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginError(String error) {

    }

    @Override
    public void goToMainScreen() {

    }
}
