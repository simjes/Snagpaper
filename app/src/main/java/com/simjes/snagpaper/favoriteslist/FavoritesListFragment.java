package com.simjes.snagpaper.favoriteslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.R;
import com.simjes.snagpaper.models.ImageModel;
import com.simjes.snagpaper.models.ImgurResponse;
import com.simjes.snagpaper.rest.ApiClient;
import com.simjes.snagpaper.wallpaperlist.EndlessScrollListener;
import com.simjes.snagpaper.wallpaperlist.GalleryAdapter;
import com.simjes.snagpaper.wallpaperlist.WallpaperListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;

public class FavoritesListFragment extends Fragment {
    @BindView(R.id.galleryBox)
    GridView galleryBox;

    private Unbinder unbinder;
    private Realm realmDatabase;

    private GalleryAdapter galleryAdapter;


    public FavoritesListFragment() {
    }

    public static FavoritesListFragment newInstance() {
        return new FavoritesListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realmDatabase = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wallpaper_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        galleryAdapter = new GalleryAdapter(getContext());
        galleryBox.setAdapter(galleryAdapter);
        getFavoritePictures();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void getFavoritePictures() {
        List<ImageModel> favoriteImages = realmDatabase.where(ImageModel.class).findAll();
        if (favoriteImages.size() > 0) {
            galleryAdapter.addNewPictures(favoriteImages);
        }
    }

    public void updateList(ImageModel image, boolean addNew) {
        if (addNew) {
            galleryAdapter.addImageToList(image);
        } else {
            galleryAdapter.removeImageFromList(image);
        }
    }
}
