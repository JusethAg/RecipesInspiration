package com.jusethag.recipesinspiration.signin.di;

import com.jusethag.recipesinspiration.signin.SigninPresenter;
import com.jusethag.recipesinspiration.signin.ui.SigninView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 8/13/16.
 */
@Module
public class SigninModule {
    SigninView signinView;

    public SigninModule(SigninView signinView) {
        this.signinView = signinView;
    }

    @Provides
    @Singleton
    SigninView providesSigninView() {
        return this.signinView;
    }




}
