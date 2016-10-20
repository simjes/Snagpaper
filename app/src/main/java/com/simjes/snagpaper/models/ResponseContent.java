package com.simjes.snagpaper.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseContent {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("followers")
    @Expose
    private Integer followers;

    @SerializedName("total_items")
    @Expose
    private Integer totalItems;

    @SerializedName("following")
    @Expose
    private Boolean following;

    @SerializedName("items")
    @Expose
    private List<ImageModel> images = new ArrayList<ImageModel>();

    public Integer getFollowers() {
        return followers;
    }

    public Boolean getFollowing() {
        return following;
    }

    public String getName() {
        return name;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public List<ImageModel> getImages() {
        return images;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }
}
