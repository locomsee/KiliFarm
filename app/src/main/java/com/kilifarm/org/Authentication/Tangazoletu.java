package com.kilifarm.org.Authentication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Tangazoletu {
    @SerializedName("error")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
