package com.example.anas.socialapp.loginpkg;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.anas.socialapp.R;
import com.example.anas.socialapp.verification.VerificationInputs;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout username ,userpassword;
    private Button loginButton;
    VerificationInputs verificationInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //init view From xml
        username = (TextInputLayout) findViewById(R.id.userLoginEmail_textInputLayout);
        userpassword = (TextInputLayout) findViewById(R.id.userLoginpassword_textInputLayout);
        loginButton = (Button) findViewById(R.id.userLogin_btn);
        verificationInputs = new VerificationInputs();
        loginButton.setOnClickListener(v -> {
            CharSequence getUserEmail = username.getEditText().getText().toString();
            CharSequence getPassword = userpassword.getEditText().getText().toString();
            if(!verificationInputs.validEmail(getUserEmail)){
                username.setError("Invalid Email!");
            }
            else if(!verificationInputs.validpassword(getPassword)){
                userpassword.setError("Invalid Password!");
            }
            else {
                username.setErrorEnabled(false);
                userpassword.setErrorEnabled(false);
                Reset();
            }
        });
    }
    protected void Reset(){
        username.getEditText().setText("");
        userpassword.getEditText().setText("");
    }
}
