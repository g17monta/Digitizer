package com.example.azmontcort.digitizer.login;


public interface LoginInteractor { // FOR THE ACTUAL SIGN UP OR SIGN IN
    void checkAlreadyAuthenticated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
