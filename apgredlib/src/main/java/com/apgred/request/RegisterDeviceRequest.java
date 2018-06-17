package com.apgred.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterDeviceRequest {

    @SerializedName("advertising_id")
    @Expose
    private String advertisingId;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("os_version")
    @Expose
    private String osVersions;
    @SerializedName("client_secret")
    @Expose
    private String clientSecret;
    @SerializedName("app_token")
    @Expose
    private String appToken;
    @SerializedName("package_name")
    @Expose
    private String packageName;
    @SerializedName("version_name")
    @Expose
    private String versionName;
    @SerializedName("version_code")
    @Expose
    private Integer versionCode;

    public String getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(String advertisingId) {
        this.advertisingId = advertisingId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersions() {
        return osVersions;
    }

    public void setOsVersions(String osVersions) {
        this.osVersions = osVersions;
    }

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

}