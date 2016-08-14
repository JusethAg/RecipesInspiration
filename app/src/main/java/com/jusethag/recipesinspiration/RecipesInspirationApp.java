package com.jusethag.recipesinspiration;

import android.app.Activity;
import android.app.Application;

import com.jusethag.recipesinspiration.domain.di.DomainModule;
import com.jusethag.recipesinspiration.libs.di.LibsModule;
import com.jusethag.recipesinspiration.signin.di.DaggerSigninComponent;
import com.jusethag.recipesinspiration.signin.di.SigninComponent;
import com.jusethag.recipesinspiration.signin.di.SigninModule;
import com.jusethag.recipesinspiration.signin.ui.SigninView;

/**
 * Created by JusethAg on 8/13/16.
 */

public class RecipesInspirationApp extends Application {

    private LibsModule libsModule;
    private DomainModule domainModule;

    @Override
    public void onCreate() {
        super.onCreate();

        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
    }

    public SigninComponent getSigninComponent(Activity activity, SigninView signinView) {
        domainModule.setActivity(activity);

        return DaggerSigninComponent
                .builder()
                .domainModule(domainModule)
                .libsModule(libsModule)
                .signinModule(new SigninModule(signinView))
                .build();
    }



}
