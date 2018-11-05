package com.example.azmontcort.digitizer.login;



public class LoginInteractorImpl implements LoginInteractor { // MOST OF THE THINGS NECESARY FOR THE PROJECT  IN ORDER TO WORK
    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void doSignUp(final String email, final String password) {
        loginRepository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }

    @Override
    public void checkAlreadyAuthenticated() {
        loginRepository.checkAlreadyAuthenticated();
    }
}
