package com.jusethag.recipesinspiration.signin;

import com.jusethag.recipesinspiration.signin.events.SigninEvent;

/**
 * Created by JusethAg on 8/13/16.
 */

public interface SigninPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(SigninEvent signinEvent);
    void signin(String email, String username, String password);
}
