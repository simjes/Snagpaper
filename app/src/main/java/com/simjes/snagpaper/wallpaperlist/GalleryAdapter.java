package com.simjes.snagpaper.wallpaperlist;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.R;
import com.simjes.snagpaper.imagedetails.ImageDetailsFragment;
import com.simjes.snagpaper.models.ImageModel;

import java.util.ArrayList;
import java.util.List;


public class GalleryAdapter extends BaseAdapter {
    private Context context;
    private List<ImageModel> images;

    public GalleryAdapter(Context context) {
        this.context = context;
        images = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ImageView img;
        if (convertView == null) {
            // If convert is null, then this means we cannot recycle an old view,
            // and need to create a new one
            img = new ImageView(context);

            // To make sure each image is displayed as you intended, you may need to assign some properties to
            // your ImageViews. I’m going to use setLayoutParams to specify how each image should be resized
            img.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));

            // setScaleType defines how the image should be scaled and positioned. I’m using the CENTER_CROP
            // value as this maintains the image’s aspect ratio by scaling it in both directions, and then
            // centers the newly-scaled image.
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(Constants.LOG_TAG, "going to details: " + images.get(position).getLink());
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

                    ImageDetailsFragment imageDetailsFragment = ImageDetailsFragment.newInstance(images.get(position).getLink());
                    //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_content, imageDetailsFragment, "details fragment")
                            .addToBackStack(null)
                            .commit();
                    //fragmentTransaction.add(imageDetailsFragment, "test");
                    //fragmentTransaction.commit();
                }
            });
        } else {
            // If the view passed to getView is not null, then recycle the view
            img = (ImageView) convertView;
        }

        // Use the position integer to select an image from the gridviewImages array, and set it to the
        // ImageView we just created
        //TODO: image not found
        Glide.with(context).load(images.get(position).getLink()).into(img);
        //img.setImageResource(gridviewImages[position]);
        return img;
    }

    public void addNewPictures(List<ImageModel> newImages) {
        Log.d(Constants.LOG_TAG, "adding new pictures, " + newImages.size());
        images.addAll(newImages);
        Log.d(Constants.LOG_TAG, "images: " + images.size());
        this.notifyDataSetChanged();
    }
}
