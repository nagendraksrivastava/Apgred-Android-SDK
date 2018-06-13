package com.apgred;


import com.apgred.interfaces.ForceUpdateCallback;
import com.apgred.pojo.ForceUpdateModel;
import com.apgred.pojo.HardUpdateOkayModel;
import com.apgred.request.ForceUpdateRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForceUpdate {

    public void checkForceUpdate(ForceUpdateRequest forceUpdateRequest, final ForceUpdateCallback forceUpdateCallback) {
        ApgredNetworkClient.getInstance()
                .getRestClient()
                .forceUpdate(forceUpdateRequest)
                .enqueue(new Callback<ForceUpdateModel>() {
                    @Override
                    public void onResponse(Call<ForceUpdateModel> call, Response<ForceUpdateModel> response) {
                        ForceUpdateModel forceUpdateModel = response.body();
                        if (forceUpdateModel.getStatus().getCode() == 200) {
                            forceUpdateCallback.onForceUpdateSuccess(forceUpdateModel);
                        } else {
                            forceUpdateCallback.onForceUpdateFailure();
                        }

                    }

                    @Override
                    public void onFailure(Call<ForceUpdateModel> call, Throwable t) {
                        forceUpdateCallback.onForceUpdateFailure();
                    }
                });
    }


    void forceUpdateOkay(final ForceUpdateCallback forceUpdateCallback) {
        ApgredNetworkClient
                .getInstance()
                .getRestClient()
                .hardUpdateOkay()
                .enqueue(new Callback<HardUpdateOkayModel>() {
                    @Override
                    public void onResponse(Call<HardUpdateOkayModel> call, Response<HardUpdateOkayModel> response) {
                        HardUpdateOkayModel hardUpdateOkayModel = response.body();
                        if (hardUpdateOkayModel.getStatus().getCode() == 200) {
                            forceUpdateCallback.hardUpdateOkaySuccess();
                        } else {
                            forceUpdateCallback.hardUpdateOkayFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<HardUpdateOkayModel> call, Throwable t) {
                        forceUpdateCallback.hardUpdateOkayFailure();
                    }
                });
    }
}
