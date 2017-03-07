package com.example.anas.socialapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anas.socialapp.Databases.DataBaseHelperClass;
import com.example.anas.socialapp.ModalClasses.UserData;
import com.example.anas.socialapp.dummy.DummyActivity;
import com.example.anas.socialapp.loginpkg.LoginActivity;
import com.example.anas.socialapp.verification.VerificationInputs;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout username,useremail,userpassword;
    private Button userSignUpButton;
    private TextView userLoginTextViewLink;
    VerificationInputs verificationInputs;
     UserData userdata ;
    DataBaseHelperClass dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init the views from xml
        username = (TextInputLayout) findViewById(R.id.username_textInputLayout);
        useremail = (TextInputLayout) findViewById(R.id.useremail_textInputLayout);
        userpassword = (TextInputLayout) findViewById(R.id.userpassword_textInputLayout);
        userSignUpButton = (Button) findViewById(R.id.userSignUp_btn);
        userLoginTextViewLink = (TextView) findViewById(R.id.userLoginLink);
        verificationInputs = new VerificationInputs();
         dbh = new DataBaseHelperClass(this);

        userSignUpButton.setOnClickListener(v->{
            SignUp();


        });
        userLoginTextViewLink.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private boolean Verification(CharSequence getUsername, CharSequence getUserEmail, CharSequence getUserPassword) {
        if (TextUtils.isEmpty(getUsername)){
            username.setError("Required");
            return false;
        }
        else if(!verificationInputs.validEmail(getUserEmail)){
            useremail.setError("Required");
            return false;
        }
        else if (!verificationInputs.validpassword(getUserPassword)){
            userpassword.setError("Required");
            return false;
        }
        else {
            username.setErrorEnabled(false);
            useremail.setErrorEnabled(false);
            userpassword.setErrorEnabled(false);
            Reset();
           return true;
        }
    }

    protected void Reset(){
        username.getEditText().setText("");
        useremail.getEditText().setText("");
        userpassword.getEditText().setText("");
    }
    protected void SignUp(){
        CharSequence getUsername = username.getEditText().getText().toString();
        CharSequence getUserEmail = useremail.getEditText().getText().toString();
        CharSequence getUserPassword = userpassword.getEditText().getText().toString();
        if (Verification(getUsername,getUserEmail,getUserPassword))
        {
            userdata = new UserData(getUsername,getUserEmail,getUserPassword);
            dbh.InsertInfo(userdata);
            userSignUpButton.setEnabled(false);
            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,R.style.AppTheme);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Creating Account...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            progressDialog.show();
            new android.os.Handler().postDelayed((Runnable) () -> {
               progressDialog.dismiss();
                signUpSuccess();
            },50000);
            Intent intent = new Intent(this,DummyActivity.class);
            startActivity(intent);
        }
        else {
            signUpUnsuccess();
        }
    }
    public void  signUpSuccess(){
          userSignUpButton.setEnabled(true);
          setResult(RESULT_OK,null);
        finish();
    }
    public void signUpUnsuccess(){
        Toast.makeText(this, "Network Problem!.....", Toast.LENGTH_SHORT).show();
        userSignUpButton.setEnabled(true);
    }
}
