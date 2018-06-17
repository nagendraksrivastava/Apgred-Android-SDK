package com.apgred;

import android.content.Context;
import android.util.Log;

import com.apgred.interfaces.ForceUpdateCallback;
import com.apgred.pojo.ForceUpdateModel;
import com.apgred.request.ForceUpdateRequest;

public class ForceUpdateImpl implements ForceUpdateCallback {


    private static final String TAG = "ForceUpdateImpl";
    private Context mContext;
    private String mClientSecret;
    private String mClientToken;

    ForceUpdateImpl(Context context, String clientSecret, String clientToken) {
        this.mContext = context;
        this.mClientSecret = clientSecret;
        this.mClientToken = clientToken;
    }

    public void checkForceUpdate() {
        new ForceUpdate().checkForceUpdate(getForceUpdateRequest(mContext, mClientSecret, mClientToken), this);
    }

    @Override
    public void onForceUpdateSuccess(ForceUpdateModel forceUpdateModel) {
        Logger.logDebug(TAG, "onForceUpdateSuccess");
        if (forceUpdateModel.getHardPush()) {
            Logger.logDebug(TAG, "Hard push is true");
            ApgredDialog.getInstance().showDialog(
                    mContext, forceUpdateModel.getDialogTitle(), forceUpdateModel.getDialogText(),
                    forceUpdateModel.getStoreUrl(), false,
                    forceUpdateModel.getDialogPostiveText(), forceUpdateModel.getDialogCancelButton(), this);
        } else if (forceUpdateModel.getSoftPush()) {
            Logger.logDebug(TAG, " soft  push is true");
            ApgredDialog.getInstance().showDialog(
                    mContext, forceUpdateModel.getDialogTitle(), forceUpdateModel.getDialogText(),
                    forceUpdateModel.getStoreUrl(), true,
                    forceUpdateModel.getDialogPostiveText(), forceUpdateModel.getDialogCancelButton(), this);
        }
    }

    @Override
    public void onForceUpdateFailure() {
        Logger.logDebug(TAG, "onForceUpdateFailure");
    }

    @Override
    public void softUpdateOkaySuccess() {

    }

    @Override
    public void softUpdateOkayFailure() {

    }

    @Override
    public void softUpdateCancelSuccess() {

    }

    @Override
    public void softUpdateCancelFailure() {

    }

    @Override
    public void hardUpdateOkaySuccess() {

    }

    @Override
    public void hardUpdateOkayFailure() {

    }

    private ForceUpdateRequest getForceUpdateRequest(Context context, String clientSecret, String clientToken) {
        ForceUpdateRequest forceUpdateRequest = new ForceUpdateRequest();
        forceUpdateRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        forceUpdateRequest.setAppToken(clientToken);
        forceUpdateRequest.setClientSecret(clientSecret);
        forceUpdateRequest.setOs(ApgredUtils.getOsName());
        forceUpdateRequest.setOsVersions(ApgredUtils.getOsVersion());
        forceUpdateRequest.setPackageName(ApgredUtils.getPackageName());
        forceUpdateRequest.setVersionName(ApgredUtils.getAppVersionName());
        forceUpdateRequest.setVersionCode(ApgredUtils.getAppVersionCode());
        return forceUpdateRequest;
    }
}
