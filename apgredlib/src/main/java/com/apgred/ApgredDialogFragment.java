package com.apgred;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.apgred.pojo.ForceUpdateModel;

public class ApgredDialogFragment extends DialogFragment {
    public ApgredDialogFragment() {
        // Empty constructor required for DialogFragment
    }

    public static ApgredDialogFragment newInstance(ForceUpdateModel forceUpdateModel) {
        ApgredDialogFragment frag = new ApgredDialogFragment();
        Bundle args = new Bundle();
        //args.putString("title", title);
        args.putParcelable("force_update_model", forceUpdateModel);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ForceUpdateModel forceUpdateModel = getArguments().getParcelable("force_update_model");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(forceUpdateModel.getDialogTitle());
        alertDialogBuilder.setMessage(forceUpdateModel.getDialogText());
        alertDialogBuilder.setPositiveButton(forceUpdateModel.getDialogPostiveText(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // on success
            }
        });

        if (forceUpdateModel.getHardPush()) {
            alertDialogBuilder.setCancelable(false);

        } else if (forceUpdateModel.getSoftPush()) {
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.setNegativeButton(forceUpdateModel.getDialogCancelButton(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }

            });
        }
        AlertDialog alertDialog = alertDialogBuilder.create();

        if (forceUpdateModel.getHardPush()) {
            alertDialog.setCanceledOnTouchOutside(false);
        } else if (forceUpdateModel.getSoftPush()) {
            alertDialog.setCanceledOnTouchOutside(true);
        }
        return alertDialog;
    }
}
