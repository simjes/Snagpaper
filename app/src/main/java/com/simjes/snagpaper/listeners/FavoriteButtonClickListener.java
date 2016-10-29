package com.simjes.snagpaper.listeners;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.MainActivity;
import com.simjes.snagpaper.SectionsPagerAdapter;
import com.simjes.snagpaper.favoriteslist.FavoritesListFragment;
import com.simjes.snagpaper.models.ImageModel;

import io.realm.Realm;

public class FavoriteButtonClickListener implements View.OnClickListener {
    private ImageModel image;
    private Realm realmDatabase;
    private FavoritesListFragment favoritesListFragment;

    public FavoriteButtonClickListener(ImageModel image, Activity activity) {
        this.image = image;

        MainActivity mainActivity = (MainActivity) activity;
        SectionsPagerAdapter sectionsPagerAdapter = mainActivity.getSectionsPagerAdapter();

        String favoriteTag = sectionsPagerAdapter.getFavoriteTag();
        favoritesListFragment = (FavoritesListFragment) mainActivity.getSupportFragmentManager().findFragmentByTag(favoriteTag);
    }

    @Override
    public void onClick(View view) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.beginTransaction();
        ImageModel imageInDatabase = realmDatabase.where(ImageModel.class).equalTo("link", image.getLink()).findFirst();
        boolean addNew;
        if (imageInDatabase == null) {
            realmDatabase.copyToRealm(image);
            addNew = true;
        } else {
            imageInDatabase.deleteFromRealm();
            addNew = false;
        }
        realmDatabase.commitTransaction();
        favoritesListFragment.updateList(image, addNew);
    }
}
