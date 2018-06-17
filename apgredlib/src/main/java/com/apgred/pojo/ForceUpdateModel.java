package com.apgred.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForceUpdateModel implements Parcelable {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("soft_push")
    @Expose
    private Boolean softPush;
    @SerializedName("hard_push")
    @Expose
    private Boolean hardPush;
    @SerializedName("store_url")
    @Expose
    private String storeUrl;
    @SerializedName("dialog_text")
    @Expose
    private String dialogText;
    @SerializedName("dialog_postive_text")
    @Expose
    private String dialogPostiveText;
    @SerializedName("dialog_title")
    @Expose
    private String dialogTitle;
    @SerializedName("dialog_cancel_button")
    @Expose
    private String dialogCancelButton;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getSoftPush() {
        return softPush;
    }

    public void setSoftPush(Boolean softPush) {
        this.softPush = softPush;
    }

    public Boolean getHardPush() {
        return hardPush;
    }

    public void setHardPush(Boolean hardPush) {
        this.hardPush = hardPush;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public String getDialogText() {
        return dialogText;
    }

    public void setDialogText(String dialogText) {
        this.dialogText = dialogText;
    }

    public String getDialogPostiveText() {
        return dialogPostiveText;
    }

    public void setDialogPostiveText(String dialogPostiveText) {
        this.dialogPostiveText = dialogPostiveText;
    }

    public String getDialogTitle() {
        return dialogTitle;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public String getDialogCancelButton() {
        return dialogCancelButton;
    }

    public void setDialogCancelButton(String dialogCancelButton) {
        this.dialogCancelButton = dialogCancelButton;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.status, flags);
        dest.writeValue(this.softPush);
        dest.writeValue(this.hardPush);
        dest.writeString(this.storeUrl);
        dest.writeString(this.dialogText);
        dest.writeString(this.dialogPostiveText);
        dest.writeString(this.dialogTitle);
        dest.writeString(this.dialogCancelButton);
    }

    public ForceUpdateModel() {
    }

    protected ForceUpdateModel(Parcel in) {
        this.status = in.readParcelable(Status.class.getClassLoader());
        this.softPush = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.hardPush = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.storeUrl = in.readString();
        this.dialogText = in.readString();
        this.dialogPostiveText = in.readString();
        this.dialogTitle = in.readString();
        this.dialogCancelButton = in.readString();
    }

    public static final Parcelable.Creator<ForceUpdateModel> CREATOR = new Parcelable.Creator<ForceUpdateModel>() {
        @Override
        public ForceUpdateModel createFromParcel(Parcel source) {
            return new ForceUpdateModel(source);
        }

        @Override
        public ForceUpdateModel[] newArray(int size) {
            return new ForceUpdateModel[size];
        }
    };
}