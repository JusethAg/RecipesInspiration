package com.jusethag.recipesinspiration.login.di;

import android.app.Activity;

import com.jusethag.recipesinspiration.domain.di.DomainModule;
import com.jusethag.recipesinspiration.libs.di.LibsModule;
import com.jusethag.recipesinspiration.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 8/14/16.
 */
@Singleton
@Component(modules = {DomainModule.class, LibsModule.class, LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
