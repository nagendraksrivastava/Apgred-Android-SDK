package com.apgred;

import android.content.Context;

import com.apgred.interfaces.ValidateCallback;
import com.apgred.request.ValidateRequest;

public class ValidateImpl implements ValidateCallback {

    private static final String TAG = "ValidateImpl";
    private Context mContext;
    private String mClientSecret;
    private String mClientToken;

    ValidateImpl(Context context, String clientSecret, String clientToken) {
        mContext = context;
        mClientSecret = clientSecret;
        mClientToken = clientToken;
    }

    public void validateClient() {
        ValidateRequest validateRequest = new ValidateRequest();
        validateRequest.setAppToken(mClientToken);
        validateRequest.setClientSecret(mClientSecret);
        new ValidateClient().validateClient(validateRequest, this);
    }


    @Override
    public void onValidationSuccess() {
        Logger.logDebug(TAG, "onValidationSuccess");
        new RegisterImpl(mContext, mClientSecret, mClientToken).register();
    }

    @Override
    public void onValidationFailure() {
        Logger.logDebug(TAG, "onValidationFailure");
    }
}
