package com.jusethag.recipesinspiration.login.di;

import com.jusethag.recipesinspiration.domain.FirebaseHelper;
import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.login.LoginInteractor;
import com.jusethag.recipesinspiration.login.LoginInteractorImpl;
import com.jusethag.recipesinspiration.login.LoginPresenter;
import com.jusethag.recipesinspiration.login.LoginPresenterImpl;
import com.jusethag.recipesinspiration.login.LoginRepository;
import com.jusethag.recipesinspiration.login.LoginRepositoryImpl;
import com.jusethag.recipesinspiration.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 8/14/16.
 */
@Module
public class LoginModule {
    LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.loginView;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView,
                                          LoginInteractor loginInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository loginRepository) {
        return new LoginInteractorImpl(loginRepository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, FirebaseHelper firebaseHelper) {
        return new LoginRepositoryImpl(eventBus, firebaseHelper);
    }
}
