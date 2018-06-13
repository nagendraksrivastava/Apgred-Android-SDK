package com.apgred;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

public class ApgredUtils {

    public static String getAdvertisingId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static String getOsName() {
        return "Android";
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public static int getAppVersionCode() {
        return BuildConfig.VERSION_CODE;
    }


    public static String getAppBuildType() {
        return BuildConfig.BUILD_TYPE;
    }

    public static String getPackageName() {
        return BuildConfig.APPLICATION_ID;
    }


}
