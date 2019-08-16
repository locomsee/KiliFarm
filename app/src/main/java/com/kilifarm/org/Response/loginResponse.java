package com.kilifarm.org.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Body;

public class loginResponse {


//    @SerializedName("phone")
//    @Expose
//    private String phone;

    @SerializedName("password")
    @Expose
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("token")
    private String token;

    @SerializedName("type")
    private String type;

    @SerializedName("phone")
    private String phone;
    @SerializedName("authorities")
    private String authorities;

    public loginResponse(String phone , String pass ) {
        this.pass = pass;
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
