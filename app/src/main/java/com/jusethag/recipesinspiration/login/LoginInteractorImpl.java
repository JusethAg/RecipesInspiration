package com.jusethag.recipesinspiration.login;

/**
 * Created by JusethAg on 8/14/16.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.login(email, password);
    }
}
