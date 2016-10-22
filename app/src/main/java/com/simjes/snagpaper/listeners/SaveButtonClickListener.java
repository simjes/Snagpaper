package com.simjes.snagpaper.listeners;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.imagedetails.AsyncSavePicture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;

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
