package com.jusethag.recipesinspiration.login.events;

/**
 * Created by JusethAg on 8/14/16.
 */
public class LoginEvent {
    public final static int onLoginSuccess = 0;
    public final static int onLoginError = 1;
    public final static int onEmptyEmailInput = 2;
    public final static int onEmptyPasswordInput = 3;

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
