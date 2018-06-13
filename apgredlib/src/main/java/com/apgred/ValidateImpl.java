package com.apgred;

import android.content.Context;

import com.apgred.interfaces.ValidateCallback;
import com.apgred.request.ValidateRequest;

public class ValidateImpl implements ValidateCallback {

    private Context mContext;

    ValidateImpl(Context context) {
        mContext = context;
    }

    public void validateClient(String token, String clientSecret) {
        ValidateRequest validateRequest = new ValidateRequest();
        validateRequest.setAppToken(token);
        validateRequest.setClientSecret(clientSecret);
        new ValidateClient().validateClient(validateRequest, this);
    }


    @Override
    public void onValidationSuccess() {
        new RegisterImpl(mContext).register();
    }

    @Override
    public void onValidationFailure() {

    }
}
