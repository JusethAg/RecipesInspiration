package com.jusethag.recipesinspiration.domain.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by JusethAg on 8/14/16.
 */
@Singleton
@Component(modules = {DomainModule.class})
public interface DomainComponent {
}
