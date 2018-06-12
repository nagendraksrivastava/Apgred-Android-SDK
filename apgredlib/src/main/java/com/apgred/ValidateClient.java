package com.apgred;

import com.apgred.pojo.RegisterModel;
import com.apgred.pojo.ValidateResponse;
import com.apgred.request.ValidateRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nagendrasrivastava on 11/06/18.
 */

final class ValidateClient {

    void validateClient(ValidateRequest validateRequest) {
        ApgredNetworkClient.getInstance()
                .getRestClient()
                .validateClient(validateRequest)
                .enqueue(new Callback<ValidateResponse>() {
                    @Override
                    public void onResponse(Call<ValidateResponse> call, Response<ValidateResponse> response) {
                        ValidateResponse validateResponse = response.body();
                        int code = validateResponse.getStatus().getCode();
                        if (code == 200) {
                            new Register().regsiterDevice();
                        } else if (code == 800) {
                            //  client is registered but app not registered
                            // send event to us
                        } else if (code == 400) {
                            // client is not registered please talk to us
                            // throw an exception
                            // send event to us
                        }
                    }

                    @Override
                    public void onFailure(Call<ValidateResponse> call, Throwable t) {

                    }
                });

    }
}
