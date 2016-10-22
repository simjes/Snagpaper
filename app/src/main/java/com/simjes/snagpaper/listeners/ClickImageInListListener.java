package com.simjes.snagpaper.listeners;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.R;
import com.simjes.snagpaper.imagedetails.ImageDetailsFragment;

public class ClickImageInListListener implements View.OnClickListener {
    private Context context;
    private String link;

    public ClickImageInListListener(Context context, String link) {
        this.context = context;
        this.link = link;
    }

    @Override
    public void onClick(View view) {
        Log.d(Constants.LOG_TAG, "going to details: " + link);
        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

        ImageDetailsFragment imageDetailsFragment = ImageDetailsFragment.newInstance(link);
        imageDetailsFragment.show(fragmentManager, "imageDetails");
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
        /*fragmentManager.beginTransaction()
                .replace(R.id.main_content, imageDetailsFragment, "imageDetailsFragment")
                .addToBackStack(null)
                .commit();*/
        //fragmentTransaction.add(imageDetailsFragment, "test");
        //fragmentTransaction.commit();
    }
}
