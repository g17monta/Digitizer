package com.example.azmontcort.digitizer.login;

// BASADO EN EL PADRE ARQUITECHTURAL QUE SE DISEÑO

public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
    void checkAlreadyAuthenticated();
}
