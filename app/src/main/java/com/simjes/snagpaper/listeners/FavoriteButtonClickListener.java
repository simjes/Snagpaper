package com.simjes.snagpaper.listeners;

import android.view.View;

import com.simjes.snagpaper.models.ImageModel;

import io.realm.Realm;

public class FavoriteButtonClickListener implements View.OnClickListener {
    private ImageModel image;
    private Realm realmDatabase;

    public FavoriteButtonClickListener(ImageModel image) {
        this.image = image;
    }

    @Override
    public void onClick(View view) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.beginTransaction();
        ImageModel imageInDatabase = realmDatabase.where(ImageModel.class).equalTo("link", image.getLink()).findFirst();
        if(imageInDatabase == null) {
            realmDatabase.copyToRealm(image);
        } else {
            imageInDatabase.deleteFromRealm();
        }
        realmDatabase.commitTransaction();

        //TODO: notify data change in favorite fragment
    }
}
