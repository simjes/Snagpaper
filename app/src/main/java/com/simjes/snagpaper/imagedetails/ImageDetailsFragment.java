package com.simjes.snagpaper.imagedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.simjes.snagpaper.Constants;
import com.simjes.snagpaper.R;
import com.simjes.snagpaper.listeners.FavoriteButtonClickListener;
import com.simjes.snagpaper.listeners.SaveButtonClickListener;
import com.simjes.snagpaper.models.ImageModel;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ImageDetailsFragment extends DialogFragment {
    @BindView(R.id.detailedImageView)
    ImageView imageView;

    @BindView(R.id.saveButtonDetails)
    Button saveButton;

    @BindView(R.id.favoriteButtonDetails)
    Button favoriteButton;

    private Unbinder unbinder;
    private ImageModel image;

    public static ImageDetailsFragment newInstance(ImageModel image) {
        ImageDetailsFragment imageDetailsFragment = new ImageDetailsFragment();
        Bundle fragmentArgs = new Bundle();
        fragmentArgs.putParcelable("image_details", Parcels.wrap(image));
        imageDetailsFragment.setArguments(fragmentArgs);
        return imageDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_details, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle fragmentArguments = getArguments();
        image = Parcels.unwrap(fragmentArguments.getParcelable("image_details"));
        saveButton.setOnClickListener(new SaveButtonClickListener(getContext(), image.getLink(), image.getDatetime().toString()));
        favoriteButton.setOnClickListener(new FavoriteButtonClickListener(image));
        Glide.with(getContext()).load(image.getLink()).into(imageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
