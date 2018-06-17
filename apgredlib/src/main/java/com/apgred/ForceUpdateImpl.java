package com.apgred;

import android.content.Context;
import android.content.Intent;

import com.apgred.interfaces.ForceUpdateCallback;
import com.apgred.pojo.ForceUpdateModel;
import com.apgred.request.ForceUpdateRequest;
import com.apgred.request.HardPushOkayRequest;
import com.apgred.request.SoftPushCancelRequest;
import com.apgred.request.SoftPushOkayRequest;

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


    public void softUpdateOkayClicked() {
        new SoftUpdate().softUpdateOkay(this, getSoftPushOkayRequest(mContext, mClientSecret, mClientToken));
    }


    public void softUpdatecancelClick() {
        new SoftUpdate().softUpdateCancel(this, getSoftPushCancelRequest(mContext, mClientSecret, mClientToken));
    }

    public void hardUpdateOkayClicked() {
        new ForceUpdate().forceUpdateOkay(this, getHardPushOkayRequest(mContext, mClientSecret, mClientToken));
    }


    @Override
    public void onForceUpdateSuccess(ForceUpdateModel forceUpdateModel) {
        Logger.logDebug(TAG, "onForceUpdateSuccess");

        if (forceUpdateModel.getHardPush() || forceUpdateModel.getSoftPush()) {
            Intent dialogIntent = new Intent(mContext, ApgredDialogActivity.class);
            dialogIntent.putExtra("force_update_model", forceUpdateModel);
            dialogIntent.putExtra("client_secret",mClientSecret);
            dialogIntent.putExtra("client_token", mClientToken);
            mContext.startActivity(dialogIntent);
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

    private HardPushOkayRequest getHardPushOkayRequest(Context context, String clientSecret, String clientToken) {
        HardPushOkayRequest hardPushOkayRequest = new HardPushOkayRequest();
        hardPushOkayRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        hardPushOkayRequest.setAppToken(clientToken);
        hardPushOkayRequest.setClientSecret(clientSecret);
        return hardPushOkayRequest;
    }


    private SoftPushOkayRequest getSoftPushOkayRequest(Context context, String clientSecret, String clientToken) {
        SoftPushOkayRequest softPushOkayRequest = new SoftPushOkayRequest();
        softPushOkayRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        softPushOkayRequest.setAppToken(clientToken);
        softPushOkayRequest.setClientSecret(clientSecret);
        return softPushOkayRequest;
    }


    private SoftPushCancelRequest getSoftPushCancelRequest(Context context, String clientSecret, String clientToken) {
        SoftPushCancelRequest softPushOkayRequest = new SoftPushCancelRequest();
        softPushOkayRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        softPushOkayRequest.setAppToken(clientToken);
        softPushOkayRequest.setClientSecret(clientSecret);
        return softPushOkayRequest;
    }
}
