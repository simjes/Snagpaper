package com.simjes.snagpaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.simjes.snagpaper.favoriteslist.FavoritesListFragment;
import com.simjes.snagpaper.wallpaperlist.WallpaperListFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private String favoriteFragmentTag;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WallpaperListFragment();
            case 1:
                return new FavoritesListFragment();
            default:
                return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
        if (position == 1) {
            favoriteFragmentTag = createdFragment.getTag();
        }
        return createdFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "New";
            case 1:
                return "Favorites";
            default:
                return null;
        }
    }

    public String getFavoriteTag() {
        return favoriteFragmentTag;
    }
}
