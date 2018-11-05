package com.example.azmontcort.digitizer.login;


import com.example.azmontcort.digitizer.login.events.LoginEvent;

//THE CONTRACT OF ALL THE ACTIONS WE DID ON THE LOG
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
