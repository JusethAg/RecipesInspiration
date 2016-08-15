package com.jusethag.recipesinspiration.splash;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import com.jusethag.recipesinspiration.R;
import com.jusethag.recipesinspiration.domain.FirebaseActionListenerCallback;
import com.jusethag.recipesinspiration.domain.FirebaseHelper;
import com.jusethag.recipesinspiration.login.ui.LoginActivity;
import com.jusethag.recipesinspiration.main.ui.MainActivity;
import com.jusethag.recipesinspiration.signin.ui.SigninActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.videoViewBackground) VideoView videoBackground;

    private FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initFirebase();
        isUserLogged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        videoBackground.start();
    }

    @Override
    protected void onDestroy() {
        videoBackground.stopPlayback();

        super.onDestroy();
    }

    @OnClick(R.id.btnLogin)
    public void goToSiginScreen(){
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.btnSignin)
    public void goToSigninScreen(){
        startActivity(new Intent(this, SigninActivity.class));
    }

    private void initFirebase() {
        firebaseHelper = new FirebaseHelper();
    }

    private void setBackgroundVideo() {
        Uri video = Uri.parse("android.resource://" +
                getPackageName() + "/" + R.raw.pour);
        videoBackground.setVideoURI(video);
        videoBackground.start();

        videoBackground.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }

    private void isUserLogged() {
        final Activity currentActivity = this;
        firebaseHelper.checkSession(new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                Intent intent = new Intent(currentActivity, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            @Override
            public void onError(String error) {
                setBackgroundVideo();
            }
        });
    }
}
