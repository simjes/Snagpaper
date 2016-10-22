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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritesListFragment extends Fragment {
    @BindView(R.id.galleryBox)
    GridView galleryBox;
    private Unbinder unbinder;

    private GalleryAdapter galleryAdapter;


    public FavoritesListFragment() {
    }

    public static FavoritesListFragment newInstance() {
        return new FavoritesListFragment();
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*galleryAdapter = new GalleryAdapter(getContext()); //needs fix?
        galleryBox.setAdapter(galleryAdapter);
        getNewImages(1);
        galleryBox.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int offset, int totalItemsCount) {
                getNewImages(offset);
                return true;
            }
        });*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /*private void getNewImages(int page) {
        Call<ImgurResponse> call = ApiClient.get().getPictures(Constants.getClientAuth(), page);
        call.enqueue(new Callback<ImgurResponse>() {
            @Override
            public void onResponse(Call<ImgurResponse> call, Response<ImgurResponse> response) {
                Log.d(Constants.LOG_TAG, "successful repsonese");
                ImgurResponse imgurResponse = response.body();
                galleryAdapter.addNewPictures(filterValidImages(imgurResponse.getData().getImages()));
            }

            @Override
            public void onFailure(Call<ImgurResponse> call, Throwable t) {
                Log.d(Constants.LOG_TAG, "failed repsonese");
                Log.e(Constants.LOG_TAG, t.toString());
            }
        });
    }

    private List<ImageModel> filterValidImages(List<ImageModel> imageList) {
        List<ImageModel> validImages = new ArrayList<>();
        for (ImageModel img : imageList) {
            if (!img.getIsAlbum() && !img.getNsfw()) {
                validImages.add(img);
            }
        }
        return validImages;
    }*/
}
