package com.simjes.snagpaper.listeners;

import android.util.Log;
import android.view.View;

import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.models.ImageModel;

public class FavoriteButtonClickListener implements View.OnClickListener {
    private ImageModel image;

    public FavoriteButtonClickListener(ImageModel image) {
        this.image = image;
    }

    @Override
    public void onClick(View view) {
        Log.d(Constants.LOG_TAG, "hello from favorite button click");
    }
}

//TODO: favorite indicator in list and in detailed view?
