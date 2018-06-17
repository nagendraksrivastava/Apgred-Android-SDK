package com.apgred;

import android.content.Context;
import android.util.Log;

import com.apgred.interfaces.RegisterInterface;
import com.apgred.request.RegisterDeviceRequest;

public class RegisterImpl implements RegisterInterface {


    private static final String TAG = "RegisterImpl";
    private Context mContext;
    private String mClientSecret;
    private String mClientToken;


    RegisterImpl(Context context, String clientSecret, String clientToken) {
        this.mContext = context;
        this.mClientSecret = clientSecret;
        this.mClientToken = clientToken;
    }

    public void register() {
        new Register().regsiterDevice(getRegisterDeviceRequest(mContext), this);
    }

    @Override
    public void onRegisterSuccess() {
        Logger.logDebug(TAG, "onRegisterSuccess");
        new ForceUpdateImpl(mContext,mClientSecret,mClientToken).checkForceUpdate();
    }

    @Override
    public void onRegisterFailure() {
        Logger.logDebug(TAG, "onRegisterFailure");
    }

    private RegisterDeviceRequest getRegisterDeviceRequest(Context context) {
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest();
        registerDeviceRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        registerDeviceRequest.setAppToken(mClientToken);
        registerDeviceRequest.setClientSecret(mClientSecret);
        registerDeviceRequest.setOs(ApgredUtils.getOsName());
        registerDeviceRequest.setOsVersions(ApgredUtils.getOsVersion());
        registerDeviceRequest.setPackageName(ApgredUtils.getPackageName());
        registerDeviceRequest.setVersionName(ApgredUtils.getAppVersionName());
        registerDeviceRequest.setVersionCode(ApgredUtils.getAppVersionCode());
        return registerDeviceRequest;
    }
}
