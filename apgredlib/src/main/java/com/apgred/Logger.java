package com.apgred;

import android.util.Log;

import com.apgred.BuildConfig;

public class Logger {

    private static boolean LOG_ENABLE = true;


    static void logVerbose(String tag, String logMessage) {
        if (LOG_ENABLE) {
            Log.v(tag, logMessage);
        }
    }


    static void logDebug(String tag, String logMessage) {
        if (LOG_ENABLE) {
            Log.d(tag, logMessage);
        }
    }


    static void logError(String tag, String logMessage) {
        if (LOG_ENABLE) {
            Log.e(tag, logMessage);
        }
    }

    static void logInformation(String tag, String logMessage) {
        if (LOG_ENABLE) {
            Log.i(tag, logMessage);
        }
    }
}
