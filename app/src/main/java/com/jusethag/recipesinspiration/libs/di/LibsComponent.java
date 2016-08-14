package com.jusethag.recipesinspiration.libs.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 8/14/16.
 */

@Singleton
@Component(modules = {LibsModule.class})
public interface LibsComponent {
}
