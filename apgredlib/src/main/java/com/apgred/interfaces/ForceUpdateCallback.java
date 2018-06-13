package com.apgred.interfaces;

import com.apgred.pojo.ForceUpdateModel;

public interface ForceUpdateCallback {

    void onForceUpdateSuccess(ForceUpdateModel forceUpdateModel);

    void onForceUpdateFailure();

    void softUpdateOkaySuccess();

    void softUpdateOkayFailure();

    void softUpdateCancelSuccess();

    void softUpdateCancelFailure();

    void hardUpdateOkaySuccess();

    void hardUpdateOkayFailure();
}
