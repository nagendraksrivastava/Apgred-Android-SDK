package com.apgred;

import android.content.Context;

import com.apgred.interfaces.ForceUpdateCallback;
import com.apgred.pojo.ForceUpdateModel;
import com.apgred.request.ForceUpdateRequest;

public class ForceUpdateImpl implements ForceUpdateCallback {


    private Context mContext;

    ForceUpdateImpl(Context context) {
        mContext = context;
    }

    public void checkForceUpdate() {
        new ForceUpdate().checkForceUpdate(getForceUpdateRequest(mContext), this);
    }

    @Override
    public void onForceUpdateSuccess(ForceUpdateModel forceUpdateModel) {
        if (forceUpdateModel.getHardPush()) {
            ApgredDialog.getInstance().showDialog(
                    mContext, forceUpdateModel.getDialogTitle(), forceUpdateModel.getDialogText(),
                    forceUpdateModel.getStoreUrl(), false,
                    forceUpdateModel.getDialogPostiveText(), forceUpdateModel.getDialogCancelButton());
        } else if (forceUpdateModel.getSoftPush()) {
            ApgredDialog.getInstance().showDialog(
                    mContext, forceUpdateModel.getDialogTitle(), forceUpdateModel.getDialogText(),
                    forceUpdateModel.getStoreUrl(), true,
                    forceUpdateModel.getDialogPostiveText(), forceUpdateModel.getDialogCancelButton());
        }
    }

    @Override
    public void onForceUpdateFailure() {

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

    private ForceUpdateRequest getForceUpdateRequest(Context context) {
        ForceUpdateRequest forceUpdateRequest = new ForceUpdateRequest();
        forceUpdateRequest.setAdvertisingId(ApgredUtils.getAdvertisingId(context));
        forceUpdateRequest.setAppToken("");
        forceUpdateRequest.setClientSecret("");
        forceUpdateRequest.setOs(ApgredUtils.getOsName());
        forceUpdateRequest.setOsVersions(ApgredUtils.getOsVersion());
        forceUpdateRequest.setPackageName(ApgredUtils.getPackageName());
        forceUpdateRequest.setVersionName(ApgredUtils.getAppVersionName());
        forceUpdateRequest.setVersionCode(ApgredUtils.getAppVersionCode());
        return forceUpdateRequest;
    }
}
