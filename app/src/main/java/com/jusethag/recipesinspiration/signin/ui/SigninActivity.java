package com.jusethag.recipesinspiration.signin.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jusethag.recipesinspiration.R;

public class SigninActivity extends AppCompatActivity implements SigninView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
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
    public void handleSignin() {

    }

    @Override
    public void signinSuccess() {

    }

    @Override
    public void signinError(String error) {

    }

    @Override
    public void setUserEmail() {

    }

    @Override
    public void goToMainScreen() {

    }
}
