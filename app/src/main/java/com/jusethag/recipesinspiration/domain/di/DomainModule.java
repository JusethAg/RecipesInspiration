package com.jusethag.recipesinspiration.domain.di;

import android.app.Activity;

import com.jusethag.recipesinspiration.domain.FirebaseHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 8/14/16.
 */
@Module
public class DomainModule {
    private Activity activity;


    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    FirebaseHelper providesFirebaseHelper(Activity activity) {
        FirebaseHelper firebaseHelper = new FirebaseHelper();
        if (activity != null) {
            firebaseHelper.setFirebaseContext(activity);
        }
        return firebaseHelper;
    }

    @Provides
    @Singleton
    Activity providesActivity() {
        return this.activity;
    }

}
