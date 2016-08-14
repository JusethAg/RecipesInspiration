package com.jusethag.recipesinspiration;

import android.app.Application;

import com.jusethag.recipesinspiration.signin.di.DaggerSigninComponent;
import com.jusethag.recipesinspiration.signin.di.SigninComponent;
import com.jusethag.recipesinspiration.signin.di.SigninModule;
import com.jusethag.recipesinspiration.signin.ui.SigninView;

/**
 * Created by JusethAg on 8/13/16.
 */

public class RecipesInspirationApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public SigninComponent getSigninComponent(SigninView signinView) {
        /*return DaggerSigninComponent
                .builder()
                .signinModule(new SigninModule(signinView))
                .build();*/

        return null;
    }

}
