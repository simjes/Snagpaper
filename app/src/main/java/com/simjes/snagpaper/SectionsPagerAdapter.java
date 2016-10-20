package com.simjes.snagpaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.simjes.snagpaper.favoriteslist.FavoritesListFragment;
import com.simjes.snagpaper.wallpaperlist.WallpaperListFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return WallpaperListFragment.newInstance(position + 1);
            case 1:
                return FavoritesListFragment.newInstance(position + 1);
            default:
                return WallpaperListFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Viral";
            case 1:
                return "Favorites";
        }
        return null;
    }
}
