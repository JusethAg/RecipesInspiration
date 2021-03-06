package com.jusethag.recipesinspiration.signin.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jusethag.recipesinspiration.R;
import com.jusethag.recipesinspiration.RecipesInspirationApp;
import com.jusethag.recipesinspiration.main.ui.MainActivity;
import com.jusethag.recipesinspiration.signin.SigninPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SigninActivity extends AppCompatActivity implements SigninView{

    @BindView(R.id.activity_signin)
    RelativeLayout layoutActivity;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtUsername)
    EditText txtUsername;
    @BindView(R.id.txtPassword)
    EditText txtPassword;
    @BindView(R.id.btnSignin)
    Button btnSignin;

    @Inject
    SigninPresenter signinPresenter;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);

        setupInjection();


        signinPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        signinPresenter.onDestroy();
        super.onDestroy();
    }

    private void setupInjection() {
        RecipesInspirationApp app = (RecipesInspirationApp) getApplication();
        app.getSigninComponent(this, this).inject(this);
    }

    @Override
    public void enableInputs() {
        setEnableInputs(true);
    }

    @Override
    public void disableInputs() {
        setEnableInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void alertEmptyEmail() {
        txtEmail.setError(getString(R.string.signin_error_message_emptyEmail));
    }

    @Override
    public void alertEmptyUsername() {
        txtUsername.setError(getString(R.string.signin_error_message_emptyUsername));
    }

    @Override
    public void alertEmptyPassword() {
        txtPassword.setError(getString(R.string.signin_error_message_emptyPassword));
    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignin() {
        signinPresenter.signin(txtEmail.getText().toString().trim(),
                txtUsername.getText().toString().trim(),
                txtPassword.getText().toString().trim());
    }

    @Override
    public void signinSuccess() {
        Snackbar.make(layoutActivity, R.string.signin_success_message_signin, Snackbar.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void signinError(String error) {
        txtPassword.setText("");
        String msgError = String.format(getString(R.string.signin_error_message_signin), error);
        Snackbar.make(layoutActivity, msgError, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setUsername(String username) {
        if (username != null) {
            String key = "";
            sharedPreferences.edit().putString(key, username).commit();
        }
    }

    private void setEnableInputs(boolean enabled){
        txtEmail.setEnabled(enabled);
        txtUsername.setEnabled(enabled);
        txtPassword.setEnabled(enabled);

        btnSignin.setEnabled(enabled);
    }
}
