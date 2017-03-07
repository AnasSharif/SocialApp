package com.example.anas.socialapp.verification;

import android.media.MediaCodec;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by anas on 3/7/17.
 */

public class VerificationInputs {
    public static final String EMAIL_PATTERN = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
    public boolean validEmail(CharSequence email){
        if (TextUtils.isEmpty(email)){
            return false;
        }
        else {
            return Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE).matcher(email).matches();
        }
    }
    public boolean validpassword(CharSequence pass){
       return pass.length() > 5;
    }
}
