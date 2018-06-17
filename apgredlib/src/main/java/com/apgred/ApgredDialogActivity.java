package com.apgred;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apgred.pojo.ForceUpdateModel;

public class ApgredDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ForceUpdateModel forceUpdateModel = getIntent().getParcelableExtra("force_update_model");
        String clientSecret = getIntent().getStringExtra("client_secret");
        String clientToken = getIntent().getStringExtra("client_token");
        showEditDialog(forceUpdateModel, clientSecret, clientToken);
    }

    private void showEditDialog(ForceUpdateModel forceUpdateModel, String clientSecret, String clientToken) {
        FragmentManager fm = getSupportFragmentManager();
        ApgredDialogFragment alertDialog = ApgredDialogFragment.newInstance(forceUpdateModel, clientSecret, clientToken);
        alertDialog.show(fm, "fragment_alert");
    }

    @Override
    public void onBackPressed() {

    }
}
