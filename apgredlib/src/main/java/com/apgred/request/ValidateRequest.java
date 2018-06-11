package com.apgred.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateRequest {

    @SerializedName("app_token")
    @Expose
    private String appToken;
    @SerializedName("client_secret")
    @Expose
    private String clientSecret;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}