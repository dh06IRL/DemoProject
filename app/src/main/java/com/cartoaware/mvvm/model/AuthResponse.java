package com.cartoaware.mvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthResponse {

    @SerializedName("token")
    @Expose
    public String authToken;

}
