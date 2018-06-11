package com.apgred;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public final class ApgredDialog {

    private static ApgredDialog INSTANCE = null;


    private ApgredDialog() {
//        if (INSTANCE != null) {
//            throw new IllegalStateException(" Already instantiated ");
//        }
    }

    public synchronized static ApgredDialog getInstance() {
        synchronized (ApgredDialog.class) {
            if (INSTANCE == null) {
                INSTANCE = new ApgredDialog();
            }
        }
        return INSTANCE;
    }


    private void showDialog(Context context, String dialogTitle, String dialogMessage,
                            String playStoreUrl, boolean isSoftupdate, String positiveButtonText, String cancelButtonText) {
        AlertDialog.Builder mAlertDialogBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mAlertDialogBuilder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            mAlertDialogBuilder = new AlertDialog.Builder(context);
        }
        mAlertDialogBuilder.setTitle(dialogTitle)
                .setMessage(dialogMessage);
        mAlertDialogBuilder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        if (isSoftupdate) {
            mAlertDialogBuilder.setNegativeButton(cancelButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        } else {
            mAlertDialogBuilder.setCancelable(false);
        }
        //TODO change the dialog alert icon
        mAlertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert).show();
    }


}
