package com.jusethag.recipesinspiration.libs.base;

/**
 * Created by JusethAg on 8/13/16.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
