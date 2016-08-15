package com.jusethag.recipesinspiration.signin.ui;

/**
 * Created by JusethAg on 8/13/16.
 */

public interface SigninView {
    void enableInputs();
    void disableInputs();

    void showProgress();
    void hideProgress();

    void alertEmptyEmail();
    void alertEmptyUsername();
    void alertEmptyPassword();

    void handleSignin();

    void signinSuccess();
    void signinError(String error);

    void setUsername(String username);
    void goToMainScreen();
}
