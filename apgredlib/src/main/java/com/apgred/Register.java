package com.apgred;

import android.content.Context;

import com.apgred.interfaces.RegisterInterface;
import com.apgred.pojo.RegisterModel;
import com.apgred.request.RegisterDeviceRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public class Register {

    void regsiterDevice(RegisterDeviceRequest registerDeviceRequest, final RegisterInterface registerInterface) {
        ApgredNetworkClient.getInstance().
                getRestClient().registerDevice(registerDeviceRequest)
                .enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        registerInterface.onRegisterSuccess();
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {
                        registerInterface.onRegisterFailure();
                    }
                });
    }


}
