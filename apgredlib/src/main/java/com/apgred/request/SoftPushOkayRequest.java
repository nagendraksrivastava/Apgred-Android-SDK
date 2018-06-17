package com.apgred.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoftPushOkayRequest {

    @SerializedName("client_secret")
    @Expose
    private String clientSecret;
    @SerializedName("app_token")
    @Expose
    private String appToken;
    @SerializedName("advertising_id")
    @Expose
    private String advertisingId;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(String advertisingId) {
        this.advertisingId = advertisingId;
    }

}