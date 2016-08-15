package com.jusethag.recipesinspiration.signin.di;

import com.jusethag.recipesinspiration.domain.FirebaseHelper;
import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.signin.SigninInteractor;
import com.jusethag.recipesinspiration.signin.SigninInteractorImpl;
import com.jusethag.recipesinspiration.signin.SigninPresenter;
import com.jusethag.recipesinspiration.signin.SigninPresenterImpl;
import com.jusethag.recipesinspiration.signin.SigninRepository;
import com.jusethag.recipesinspiration.signin.SigninRepositoryImpl;
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


    @Provides
    @Singleton
    SigninPresenter providesSigninPresenter(EventBus eventBus, SigninView signinView,
                                            SigninInteractor signinInteractor) {
        return new SigninPresenterImpl(eventBus, signinView, signinInteractor);
    }

    @Provides
    @Singleton
    SigninInteractor providesSigninInteractor(SigninRepository signinRepository) {
        return new SigninInteractorImpl(signinRepository);
    }

    @Provides
    @Singleton
    SigninRepository providesSigninRepository(EventBus eventBus, FirebaseHelper firebaseHelper) {
        return new SigninRepositoryImpl(eventBus, firebaseHelper);
    }
}
