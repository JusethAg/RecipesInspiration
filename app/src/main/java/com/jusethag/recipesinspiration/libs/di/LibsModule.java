package com.jusethag.recipesinspiration.libs.di;

import android.app.Fragment;

import com.jusethag.recipesinspiration.libs.GlideImageLoader;
import com.jusethag.recipesinspiration.libs.GreenRobotEventBus;
import com.jusethag.recipesinspiration.libs.base.EventBus;
import com.jusethag.recipesinspiration.libs.base.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JusethAg on 8/14/16.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader glideImageLoader = new GlideImageLoader();
        if (fragment != null) {
            glideImageLoader.setLoaderContext(fragment);
        }
        return glideImageLoader;
    }

    @Provides
    @Singleton
    Fragment providesFragment() {
        return this.fragment;
    }
}
