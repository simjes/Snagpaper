package com.simjes.snagpaper.listeners;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.imagedetails.ImageDetailsFragment;
import com.simjes.snagpaper.models.ImageModel;

public class ClickImageInListListener implements View.OnClickListener {
    private Context context;
    private ImageModel image;

    public ClickImageInListListener(Context context, ImageModel image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public void onClick(View view) {
        Log.d(Constants.LOG_TAG, "going to details: " + image.getLink());
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

        ImageDetailsFragment imageDetailsFragment = ImageDetailsFragment.newInstance();
        imageDetailsFragment.setImage(image);
        imageDetailsFragment.show(fragmentManager, "imageDetails");
    }
}
