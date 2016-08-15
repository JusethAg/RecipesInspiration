package com.jusethag.recipesinspiration.signin.events;

/**
 * Created by JusethAg on 8/14/16.
 */

public class SigninEvent {
    public final static int onSigninSuccess = 0;
    public final static int onSigninError = 1;
    public final static int onEmptyEmailInput = 2;
    public final static int onEmptyUsernameInput = 3;
    public final static int onEmptyPasswordInput = 4;

    private int type;
    private String errorMessage;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
