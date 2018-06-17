package com.apgred;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.apgred.pojo.ForceUpdateModel;

public class ApgredDialogFragment extends DialogFragment {
    public ApgredDialogFragment() {
        // Empty constructor required for DialogFragment
    }

    public static ApgredDialogFragment newInstance(ForceUpdateModel forceUpdateModel, String clientSecret, String clientToken) {
        ApgredDialogFragment frag = new ApgredDialogFragment();
        Bundle args = new Bundle();
        //args.putString("title", title);
        args.putParcelable("force_update_model", forceUpdateModel);
        args.putString("client_secret", clientSecret);
        args.putString("client_token", clientToken);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ForceUpdateModel forceUpdateModel = getArguments().getParcelable("force_update_model");
        final String clientSecret = getArguments().getString("client_secret");
        final String clientToken = getArguments().getString("client_token");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(forceUpdateModel.getDialogTitle());
        alertDialogBuilder.setMessage(forceUpdateModel.getDialogText());
        alertDialogBuilder.setPositiveButton(forceUpdateModel.getDialogPostiveText(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(forceUpdateModel.getStoreUrl())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(forceUpdateModel.getStoreUrl())));
                }
                if (forceUpdateModel.getHardPush()) {
                    new ForceUpdateImpl(getContext(), clientSecret, clientToken).hardUpdateOkayClicked();
                } else if (forceUpdateModel.getSoftPush()) {
                    new ForceUpdateImpl(getContext(), clientSecret, clientToken).softUpdateOkayClicked();
                }
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
                    new ForceUpdateImpl(getContext(), clientSecret, clientToken).softUpdatecancelClick();
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
