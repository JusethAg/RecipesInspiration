package com.jusethag.recipesinspiration.login;

import com.jusethag.recipesinspiration.domain.FirebaseActionListenerCallback;
import com.jusethag.recipesinspiration.domain.FirebaseHelper;
import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.login.events.LoginEvent;

/**
 * Created by JusethAg on 8/14/16.
 */

public class LoginRepositoryImpl implements LoginRepository {

    private EventBus eventBus;
    private FirebaseHelper firebaseHelper;

    public LoginRepositoryImpl(EventBus eventBus, FirebaseHelper firebaseHelper) {
        this.eventBus = eventBus;
        this.firebaseHelper = firebaseHelper;
    }

    @Override
    public void login(String email, String password) {
        if (!isEmptyInput(email, password)) {
            firebaseHelper.login(email, password, new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    post(LoginEvent.onLoginSuccess);
                }

                @Override
                public void onError(String error) {
                    post(LoginEvent.onLoginError, error);
                }
            });
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        LoginEvent signinEvent = new LoginEvent();
        signinEvent.setType(type);
        signinEvent.setErrorMessage(errorMessage);
        eventBus.post(signinEvent);
    }

    private boolean isEmptyInput(String email, String password) {
        if (email.isEmpty()){
            post(LoginEvent.onEmptyEmailInput);
            return true;
        } else if (password.isEmpty()) {
            post(LoginEvent.onEmptyPasswordInput);
            return true;
        }
        return false;
    }
}
