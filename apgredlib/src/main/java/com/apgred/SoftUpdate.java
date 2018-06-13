package com.apgred;


import com.apgred.interfaces.ForceUpdateCallback;
import com.apgred.pojo.RegisterModel;
import com.apgred.pojo.SoftUpdateOkayModel;
import com.apgred.pojo.SoftupdateCancelModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoftUpdate {


    public void softUpdateOkay(final ForceUpdateCallback forceUpdateCallback) {
        ApgredNetworkClient.getInstance().getRestClient()
                .softUpdateOkay().enqueue(new Callback<SoftUpdateOkayModel>() {
            @Override
            public void onResponse(Call<SoftUpdateOkayModel> call, Response<SoftUpdateOkayModel> response) {
                SoftUpdateOkayModel softUpdateOkayModel = response.body();
                if (softUpdateOkayModel.getStatus().getCode() == 200) {
                    forceUpdateCallback.softUpdateOkaySuccess();
                } else {
                    forceUpdateCallback.softUpdateOkayFailure();
                }
            }

            @Override
            public void onFailure(Call<SoftUpdateOkayModel> call, Throwable t) {
                forceUpdateCallback.softUpdateOkayFailure();
            }
        });

    }


    public void softUpdateCancel(final ForceUpdateCallback forceUpdateCallback) {
        ApgredNetworkClient.getInstance().getRestClient()
                .softUpdateCancelled()
                .enqueue(new Callback<SoftupdateCancelModel>() {
                    @Override
                    public void onResponse(Call<SoftupdateCancelModel> call, Response<SoftupdateCancelModel> response) {
                        SoftupdateCancelModel softupdateCancelModel = response.body();
                        if (softupdateCancelModel.getStatus().getCode() == 200) {
                            forceUpdateCallback.softUpdateCancelSuccess();
                        } else {
                            forceUpdateCallback.softUpdateCancelFailure();
                        }

                    }

                    @Override
                    public void onFailure(Call<SoftupdateCancelModel> call, Throwable t) {
                        forceUpdateCallback.softUpdateCancelFailure();
                    }
                });
    }
}
