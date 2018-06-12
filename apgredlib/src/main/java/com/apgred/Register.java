package com.apgred;

import com.apgred.pojo.RegisterModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public class Register {

    void regsiterDevice(){
        ApgredNetworkClient.getInstance().
                getRestClient().registerDevice()
                .enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        new ForceUpdate().checkForceUpdate();
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {

                    }
                });
    }


}
