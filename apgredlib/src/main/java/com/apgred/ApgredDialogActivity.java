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
        showEditDialog(forceUpdateModel);
    }

    private void showEditDialog(ForceUpdateModel forceUpdateModel) {
        FragmentManager fm = getSupportFragmentManager();
        ApgredDialogFragment alertDialog = ApgredDialogFragment.newInstance(forceUpdateModel);
        alertDialog.show(fm, "fragment_alert");
    }

    @Override
    public void onBackPressed() {
        
    }
}
