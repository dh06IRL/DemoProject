package com.cartoaware.mvvm.model;

public class AuthBody {

    String email;
    String password;

    public AuthBody(String email, String password){
        this.email = email;
        this.password = password;
    }
}
