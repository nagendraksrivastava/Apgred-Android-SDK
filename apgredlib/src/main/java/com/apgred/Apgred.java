package com.apgred;

import android.app.Application;
import android.content.Context;

import com.apgred.interfaces.ForceUpdateCallback;
import com.apgred.pojo.ForceUpdateModel;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public final class Apgred {

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
        if (!(context instanceof Application)) {
            throw new IllegalArgumentException("Context must application context which can " +
                    "be get by using getApplicationContext() ");
        }
        new ValidateImpl(context).validateClient(token, clientSecret);
    }
}
