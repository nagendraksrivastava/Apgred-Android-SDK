package com.apgred;

import android.content.Context;
import android.util.Log;

import com.apgred.interfaces.ValidateCallback;
import com.apgred.pojo.ValidateResponse;
import com.apgred.request.ValidateRequest;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nagendrasrivastava on 11/06/18.
 */

final class ValidateClient {

    private static final String TAG = "ValidateClient";

    void validateClient(ValidateRequest validateRequest, final ValidateCallback validateCallback) {
        Log.d(TAG, "Request json is = " + new Gson().toJson(validateRequest));
        ApgredNetworkClient.getInstance()
                .getRestClient()
                .validateClient(validateRequest)
                .enqueue(new Callback<ValidateResponse>() {
                    @Override
                    public void onResponse(Call<ValidateResponse> call, Response<ValidateResponse> response) {
                        ValidateResponse validateResponse = response.body();
                        Log.d(TAG, "Response body is = " + response.body());
                        int code = validateResponse.getStatus().getCode();
                        if (code == 200) {
                            validateCallback.onValidationSuccess();
                        } else if (code == 800) {
                            validateCallback.onValidationFailure();
                        } else if (code == 400) {
                            validateCallback.onValidationFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<ValidateResponse> call, Throwable t) {
                        Log.d(TAG, " error message " + t.getMessage());
                        validateCallback.onValidationFailure();

                    }
                });

    }
}
