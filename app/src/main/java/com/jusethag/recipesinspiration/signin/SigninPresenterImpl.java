package com.jusethag.recipesinspiration.signin;

import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.signin.events.SigninEvent;
import com.jusethag.recipesinspiration.signin.ui.SigninView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by JusethAg on 8/14/16.
 */

public class SigninPresenterImpl implements SigninPresenter {

    private EventBus eventBus;
    private SigninView signinView;
    private SigninInteractor signinInteractor;

    public SigninPresenterImpl(EventBus eventBus, SigninView signinView, SigninInteractor signinInteractor) {
        this.eventBus = eventBus;
        this.signinView = signinView;
        this.signinInteractor = signinInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        signinView = null;
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventMainThread(SigninEvent signinEvent) {
        switch (signinEvent.getType()) {
            case SigninEvent.onSigninSuccess:
                onSigninSuccess();
                break;
            case SigninEvent.onSigninError:
                onSigninError(signinEvent.getErrorMessage());
                break;
            case SigninEvent.onEmptyEmailInput:
                onSigninEmptyEmailInput();
                break;
            case SigninEvent.onEmptyUsernameInput:
                onSigninEmptyUsernameInput();
                break;
            case SigninEvent.onEmptyPasswordInput:
                onSigninEmptyPasswordInput();
                break;
        }
    }

    @Override
    public void signin(String email, String username, String password) {
        if (signinView != null) {
            signinView.disableInputs();
            signinView.showProgress();
        }

        signinInteractor.execute(email, username, password);
    }

    private void onSigninSuccess() {
        if (signinView != null) {
            signinView.signinSuccess();
        }

    }

    private void onSigninError(String error) {
        if (signinView != null) {
            signinView.hideProgress();
            signinView.enableInputs();
            signinView.signinError(error);
        }
    }

    private void onSigninEmptyEmailInput() {
        if (signinView != null) {
            signinView.hideProgress();
            signinView.enableInputs();
            signinView.alertEmptyEmail();
        }
    }

    private void onSigninEmptyUsernameInput() {
        if (signinView != null) {
            signinView.hideProgress();
            signinView.enableInputs();
            signinView.alertEmptyUsername();
        }
    }

    private void onSigninEmptyPasswordInput() {
        if (signinView != null) {
            signinView.hideProgress();
            signinView.enableInputs();
            signinView.alertEmptyPassword();
        }
    }
}
