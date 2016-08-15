package com.jusethag.recipesinspiration.domain;

import android.app.Activity;
import android.support.annotation.NonNull;
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
                        firebaseCallback.onSuccess();

                        if(!task.isSuccessful()) {
                            Toast.makeText(activity, "sign inFAlló tasks", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(activity, "sign in FAlló listener", Toast.LENGTH_SHORT).show();

                        firebaseCallback.onError(e.getMessage());
                    }
                });
    }

    public void login(String email, String password,
                      final FirebaseActionListenerCallback firebaseCallback) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        firebaseCallback.onSuccess();

                        if(!task.isSuccessful()) {
                            Toast.makeText(activity, "log in FAlló tasks", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(activity, "log in FAlló listener", Toast.LENGTH_SHORT).show();

                        firebaseCallback.onError(e.getMessage());
                    }
                });
    }

    public void logout() {
        firebaseAuth.signOut();
    }

}
