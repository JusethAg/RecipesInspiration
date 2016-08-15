package com.jusethag.recipesinspiration.login;

import com.jusethag.recipesinspiration.login.events.LoginEvent;

/**
 * Created by JusethAg on 8/14/16.
 */

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent loginEvent);
    void login(String email, String password);
}
