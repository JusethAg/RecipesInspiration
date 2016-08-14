package com.jusethag.recipesinspiration.splash;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import com.jusethag.recipesinspiration.R;
import com.jusethag.recipesinspiration.login.ui.LoginActivity;
import com.jusethag.recipesinspiration.signin.ui.SigninActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.videoViewBackground) VideoView videoBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        setBackgroundVideo();

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

    @OnClick(R.id.btnLogin)
    public void goToSiginScreen(){
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.btnSignin)
    public void goToSigninScreen(){
        startActivity(new Intent(this, SigninActivity.class));
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
}
