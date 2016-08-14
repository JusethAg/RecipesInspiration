package com.jusethag.recipesinspiration.libs;


import com.jusethag.recipesinspiration.libs.base.EventBus;

/**
 * Created by JusethAg on 8/13/16.
 */

public class GreenRobotEventBus implements EventBus {

    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus() {
        this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(eventBus);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
