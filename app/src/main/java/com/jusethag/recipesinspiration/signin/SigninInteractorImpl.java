package com.jusethag.recipesinspiration.signin;

/**
 * Created by JusethAg on 8/14/16.
 */

public class SigninInteractorImpl implements SigninInteractor {

    private SigninRepository signinRepository;

    public SigninInteractorImpl(SigninRepository signinRepository) {
        this.signinRepository = signinRepository;
    }

    @Override
    public void execute(String email, String username, String password) {
        signinRepository.signin(email, username, password);
    }
}
