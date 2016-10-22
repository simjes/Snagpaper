package com.simjes.snagpaper.listeners;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.imagedetails.ImageDetailsFragment;

public class ClickImageInListListener implements View.OnClickListener {
    private Context context;
    private String imageLink;
    private String imageName;

    public ClickImageInListListener(Context context, String imageLink, String imageName) {
        this.context = context;
        this.imageLink = imageLink;
        this.imageName = imageName;
    }

    @Override
    public void onClick(View view) {
        Log.d(Constants.LOG_TAG, "going to details: " + imageLink);
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

        ImageDetailsFragment imageDetailsFragment = ImageDetailsFragment.newInstance(imageLink, imageName);
        imageDetailsFragment.show(fragmentManager, "imageDetails");
    }
}
