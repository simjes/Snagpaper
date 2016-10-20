package com.simjes.snagpaper.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgurResponse {
    @SerializedName("data")
    @Expose
    private ResponseContent data;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status")
    @Expose
    private Integer status;

    public ResponseContent getData() {
        return data;
    }

    public void setData(ResponseContent data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
