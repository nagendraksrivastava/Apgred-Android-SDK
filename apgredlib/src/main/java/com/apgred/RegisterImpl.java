package com.apgred;

import android.content.Context;

import com.apgred.interfaces.RegisterInterface;
import com.apgred.request.RegisterDeviceRequest;

public class RegisterImpl implements RegisterInterface {


    private Context mContext;

     RegisterImpl(Context context) {
        this.mContext = context;
    }

    public void register() {
        new Register().regsiterDevice(getRegisterDeviceRequest(mContext), this);
    }

    @Override
    public void onRegisterSuccess() {
        new ForceUpdateImpl(mContext).checkForceUpdate();
    }

    @Override
    public void onRegisterFailure() {

    }

    private RegisterDeviceRequest getRegisterDeviceRequest(Context context) {
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest();
        registerDeviceRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        registerDeviceRequest.setAppToken("");
        registerDeviceRequest.setClientSecret("");
        registerDeviceRequest.setOs(ApgredUtils.getOsName());
        registerDeviceRequest.setOsVersions(ApgredUtils.getOsVersion());
        registerDeviceRequest.setPackageName(ApgredUtils.getPackageName());
        registerDeviceRequest.setVersionName(ApgredUtils.getAppVersionName());
        registerDeviceRequest.setVersionCode(ApgredUtils.getAppVersionCode());
        return registerDeviceRequest;
    }
}
