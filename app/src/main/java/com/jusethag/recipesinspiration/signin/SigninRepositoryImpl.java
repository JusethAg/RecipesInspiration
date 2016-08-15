package com.jusethag.recipesinspiration.signin;

import android.util.Log;

import com.jusethag.recipesinspiration.domain.FirebaseActionListenerCallback;
import com.jusethag.recipesinspiration.domain.FirebaseHelper;
import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.login.events.LoginEvent;
import com.jusethag.recipesinspiration.signin.events.SigninEvent;

/**
 * Created by JusethAg on 8/14/16.
 */

public class SigninRepositoryImpl implements SigninRepository {

    private EventBus eventBus;
    private FirebaseHelper firebaseHelper;

    public SigninRepositoryImpl(EventBus eventBus, FirebaseHelper firebaseHelper) {
        this.eventBus = eventBus;
        this.firebaseHelper = firebaseHelper;
    }

    @Override
    public void signin(final String email, String username, final String password) {
        if (!isEmptyInput(email, username, password)) {
            firebaseHelper.signin(email, password, new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {

                    firebaseHelper.login(email, password, new FirebaseActionListenerCallback() {
                        @Override
                        public void onSuccess() {
                            post(SigninEvent.onSigninSuccess);
                        }

                        @Override
                        public void onError(String error) {
                            post(SigninEvent.onSigninError, error.toString());
                        }
                    });
                }

                @Override
                public void onError(String error) {
                    post(SigninEvent.onSigninError, error.toString());
                }
            });
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        SigninEvent signinEvent = new SigninEvent();
        signinEvent.setType(type);
        signinEvent.setErrorMessage(errorMessage);
        eventBus.post(signinEvent);
    }


    private boolean isEmptyInput(String email, String username, String password) {
        if (email.isEmpty()){
            post(SigninEvent.onEmptyEmailInput);
            return true;
        } else if (username.isEmpty()) {
            post(SigninEvent.onEmptyUsernameInput);
            return true;
        } else if (password.isEmpty()) {
            post(SigninEvent.onEmptyPasswordInput);
            return true;
        }
        return false;
    }
}
