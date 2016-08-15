package com.jusethag.recipesinspiration.domain;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by JusethAg on 8/14/16.
 */

public class FirebaseHelper {
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private Activity activity;

    public FirebaseHelper() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseUser = firebaseAuth.getCurrentUser();

    }

    public void setFirebaseContext(Activity activity) {
        this.activity = activity;
    }

    public void signin(String email, String password,
                       final FirebaseActionListenerCallback firebaseCallback) {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            firebaseCallback.onSuccess();
                        } else {
                            firebaseCallback.onError(task.getException().getMessage());
                        }
                    }
                });
    }

    public void login(String email, String password,
                      final FirebaseActionListenerCallback firebaseCallback) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            firebaseCallback.onSuccess();
                        } else {
                            firebaseCallback.onError(task.getException().getMessage());
                        }
                    }
                })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

    public void logout() {
        firebaseAuth.signOut();
    }

}
