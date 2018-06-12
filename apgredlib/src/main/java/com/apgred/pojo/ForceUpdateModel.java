package com.apgred.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForceUpdateModel {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("soft_push")
    @Expose
    private Boolean softPush;
    @SerializedName("hard_push")
    @Expose
    private Boolean hardPush;

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

}