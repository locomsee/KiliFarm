package com.kilifarm.org.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registration {

    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private  String email;
   @SerializedName("password")
    private String password;

   @SerializedName("error")
   @Expose
   private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Registration(String first_name, String last_name, String phone, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
