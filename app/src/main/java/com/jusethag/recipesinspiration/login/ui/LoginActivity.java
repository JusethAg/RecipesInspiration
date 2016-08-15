package com.jusethag.recipesinspiration.login.ui;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.jusethag.recipesinspiration.R;
import com.jusethag.recipesinspiration.RecipesInspirationApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.activity_login)
    RelativeLayout layoutActivity;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtPassword)
    EditText txtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setupInjection();
        //TODO: Call onCreate presenter's method
    }

    protected void onDestroy() {
        //TODO: Destroy presenter
        super.onDestroy();
    }

    private void setupInjection() {
        RecipesInspirationApp app = (RecipesInspirationApp) getApplication();
        //TODO: Call dependency for login activity
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
        txtEmail.setError(getString(R.string.login_error_message_emptyEmail));
    }

    @Override
    public void alertEmptyPassword() {
        txtEmail.setError(getString(R.string.login_error_message_emptyPassword));
    }

    @Override
    @OnClick(R.id.btnLogin)
    public void handleLogin() {
        //TODO: Call to presenter method (Execute)
    }


    @Override
    public void loginError(String error) {
        txtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_login), error);
        Snackbar.make(layoutActivity, msgError, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void goToMainScreen() {
        //TODO: Start MainActivity
        //startActivity(new Intent(this, MainActivity.class));
        Log.e(getClass().getName(), "ACCESSING....");
    }

    private void setEnableInputs(boolean enabled) {
        txtEmail.setEnabled(enabled);
        txtPassword.setEnabled(enabled);
        btnLogin.setEnabled(enabled);
    }
}
