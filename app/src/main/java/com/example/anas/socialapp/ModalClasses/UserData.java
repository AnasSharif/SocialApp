package com.example.anas.socialapp.ModalClasses;

/**
 * Created by anas on 3/7/17.
 */

public class UserData{
    CharSequence username;
    CharSequence email;
    CharSequence password;

    public UserData() {
    }

    public UserData(CharSequence username, CharSequence email, CharSequence password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public CharSequence getUsername() {
        return username;
    }

    public void setUsername(CharSequence username) {
        this.username = username;
    }

    public CharSequence getEmail() {
        return email;
    }

    public void setEmail(CharSequence email) {
        this.email = email;
    }

    public CharSequence getPassword() {
        return password;
    }

    public void setPassword(CharSequence password) {
        this.password = password;
    }
}
