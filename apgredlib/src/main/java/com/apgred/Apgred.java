package com.apgred;

import android.content.Context;

import com.apgred.request.ValidateRequest;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public class Apgred {

    private static Apgred INSTANCE;

    private Apgred() {

    }

    public static Apgred getInstance() {

        synchronized (Apgred.class) {
            if (INSTANCE == null) {
                INSTANCE = new Apgred();
            }
        }
        return INSTANCE;
    }

    public void init(Context context, String clientSecret, String token) {
        ValidateRequest validateRequest = new ValidateRequest();
        validateRequest.setAppToken(token);
        validateRequest.setClientSecret(clientSecret);
        new ValidateClient().validateClient(validateRequest);
    }

}
