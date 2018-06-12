package com.apgred;


import com.apgred.pojo.RegisterModel;
import com.apgred.pojo.SoftUpdateOkayModel;
import com.apgred.pojo.SoftupdateCancelModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoftUpdate {



    public void softUpdateOkay(){
        ApgredNetworkClient.getInstance().getRestClient()
                .softUpdateOkay().enqueue(new Callback<SoftUpdateOkayModel>() {
            @Override
            public void onResponse(Call<SoftUpdateOkayModel> call, Response<SoftUpdateOkayModel> response) {
                SoftUpdateOkayModel softUpdateOkayModel = response.body();
            }

            @Override
            public void onFailure(Call<SoftUpdateOkayModel> call, Throwable t) {

            }
        });

    }


    public  void softUpdateCancel(){
        ApgredNetworkClient.getInstance().getRestClient()
                .softUpdateCancelled()
                .enqueue(new Callback<SoftupdateCancelModel>() {
                    @Override
                    public void onResponse(Call<SoftupdateCancelModel> call, Response<SoftupdateCancelModel> response) {

                    }

                    @Override
                    public void onFailure(Call<SoftupdateCancelModel> call, Throwable t) {

                    }
                });
    }
}
