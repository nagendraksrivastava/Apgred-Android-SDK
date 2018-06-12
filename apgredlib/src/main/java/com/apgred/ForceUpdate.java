package com.apgred;


import com.apgred.pojo.ForceUpdateModel;
import com.apgred.pojo.HardUpdateOkayModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForceUpdate {

    public void checkForceUpdate(){
        ApgredNetworkClient.getInstance()
                .getRestClient()
                .forceUpdate()
                .enqueue(new Callback<ForceUpdateModel>() {
                    @Override
                    public void onResponse(Call<ForceUpdateModel> call, Response<ForceUpdateModel> response) {
                            ForceUpdateModel forceUpdateModel = response.body();
                            if (forceUpdateModel.getStatus().getCode() == 200){
                                if (forceUpdateModel.getHardPush()){
                                    ApgredDialog.getInstance().showDialog();
                                }else if (forceUpdateModel.getSoftPush()){
                                    ApgredDialog.getInstance().showDialog();
                                }else {
                                    // something went wrong
                                }
                            }
                    }

                    @Override
                    public void onFailure(Call<ForceUpdateModel> call, Throwable t) {

                    }
                });
    }


    public void forceUpdateOkay(){
        ApgredNetworkClient
                .getInstance()
                .getRestClient()
                .hardUpdateOkay()
                .enqueue(new Callback<HardUpdateOkayModel>() {
                    @Override
                    public void onResponse(Call<HardUpdateOkayModel> call, Response<HardUpdateOkayModel> response) {

                    }

                    @Override
                    public void onFailure(Call<HardUpdateOkayModel> call, Throwable t) {

                    }
                });
    }
}
