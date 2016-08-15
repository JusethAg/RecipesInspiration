package com.jusethag.recipesinspiration.login;

import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.login.events.LoginEvent;
import com.jusethag.recipesinspiration.login.ui.LoginView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by JusethAg on 8/14/16.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private EventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(EventBus eventBus, LoginView loginView,
                              LoginInteractor loginInteractor) {
        this.eventBus = eventBus;
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }


    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent loginEvent) {
        switch (loginEvent.getType()) {
            case LoginEvent.onLoginSuccess:
                onLoginSuccess();
                break;
            case LoginEvent.onLoginError:
                onLoginError(loginEvent.getErrorMessage());
                break;
            case LoginEvent.onEmptyEmailInput:
                onLoginEmptyEmailInput();
                break;
            case LoginEvent.onEmptyPasswordInput:
                onLoginEmptyPasswordInput();
                break;
        }
    }



    @Override
    public void login(String email, String password) {
        if (loginView != null) {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.execute(email, password);
    }

    private void onLoginSuccess() {
        if (loginView != null) {
            loginView.goToMainScreen();
        }
    }

    private void onLoginError(String error) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onLoginEmptyEmailInput() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.alertEmptyEmail();
        }
    }

    private void onLoginEmptyPasswordInput() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.alertEmptyPassword();
        }
    }
}
