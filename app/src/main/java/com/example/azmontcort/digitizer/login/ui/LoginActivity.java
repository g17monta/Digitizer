package com.example.azmontcort.digitizer.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.azmontcort.digitizer.MainActivity;
import com.example.azmontcort.digitizer.R;
//import com.example.azmontcort.digitizer.contactlist.ui.ContactListActivity;
import com.example.azmontcort.digitizer.SurveyActivity;
import com.example.azmontcort.digitizer.login.LoginPresenter;
import com.example.azmontcort.digitizer.login.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// AQUI VA TODA LA PARTE DE UI, ES LA LOG IN SCREEN


public class LoginActivity extends AppCompatActivity
                           implements LoginView {
    @BindView(R.id.btnSignin)
    Button btnSignIn;
    @BindView(R.id.btnSignup)
    Button btnSignUp;
    @BindView(R.id.editTxtEmail)
    EditText inputEmail;
    @BindView(R.id.editTxtPassword)
    EditText inputPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.layoutMainContainer)
    RelativeLayout container;

    private LoginPresenter loginPresenter;

    private static final String TAG = "On Signup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    @OnClick(R.id.btnSignup)
    public void handleSignUp() {

        // try and catch

       // if ((inputEmail.getText().toString() != null) && ( inputPassword.getText().toString() != null)) {
        String inputEmailS = inputEmail.getText().toString();
        if (inputEmailS == null)  {
            // User is signed in
            Log.d(TAG, "onAuthStateChanged:signed_up:" + inputEmail);
            toastMessage("Successfully signed in with: " + inputEmail.getText().toString());
            loginPresenter.registerNewUser(inputEmail.getText().toString(),
                    inputPassword.getText().toString());
        } else {
            // User is not correctly signed
            Log.d(TAG, "Fail onAuthStateChanged:signed_out");
            toastMessage("Unsuccessfully signed up.");
        }

    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignIn() {
        loginPresenter.validateLogin(inputEmail.getText().toString(),
                inputPassword.getText().toString());
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
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        inputPassword.setError(msgError);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void newUserError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        inputPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(container, R.string.login_notice_message_useradded, Snackbar.LENGTH_SHORT).show();
    }

    private void setInputs(boolean enabled){
        btnSignIn.setEnabled(true);
        btnSignUp.setEnabled(true);
        inputEmail.setEnabled(true);
        inputPassword.setEnabled(true);
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
