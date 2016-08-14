package com.jusethag.recipesinspiration.signin;

/**
 * Created by JusethAg on 8/13/16.
 */

public interface SigninPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread();
    void signin(String email, String username, String password);
}
