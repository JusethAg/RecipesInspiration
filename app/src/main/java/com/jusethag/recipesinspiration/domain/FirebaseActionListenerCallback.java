package com.jusethag.recipesinspiration.domain;

/**
 * Created by JusethAg on 8/14/16.
 */

public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(Object error);
}
