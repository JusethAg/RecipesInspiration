package com.jusethag.recipesinspiration.login.ui;

/**
 * Created by JusethAg on 8/13/16.
 */

public interface LoginView {
    void enableInputs();
    void disableInputs();

    void showProgress();
    void hideProgress();

    void alertEmptyEmail();
    void alertEmptyPassword();

    void handleLogin();

    void loginError(String error);

    void goToMainScreen();
}
