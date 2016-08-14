package com.jusethag.recipesinspiration.signin.di;

import com.jusethag.recipesinspiration.libs.di.LibsModule;
import com.jusethag.recipesinspiration.signin.ui.SigninActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 8/13/16.
 */
@Singleton
@Component(modules = {LibsModule.class, SigninModule.class})
public interface SigninComponent {
    void inject(SigninActivity signinActivity);
}
