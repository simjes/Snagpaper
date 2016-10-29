package com.simjes.snagpaper.listeners;

import android.content.Context;
import android.view.View;

import com.simjes.snagpaper.imagedetails.AsyncSavePicture;


public class SaveButtonClickListener implements View.OnClickListener {

    private String imageLink;
    private String imageName;
    private Context context;

    public SaveButtonClickListener(Context context, String imageLink, String imageName) {
        this.context = context;
        this.imageLink = imageLink;
        this.imageName = imageName;
    }

    @Override
    public void onClick(View view) {
        AsyncSavePicture saveImageToDevice = new AsyncSavePicture(context);
        saveImageToDevice.execute(imageLink, imageName);
    }
}
