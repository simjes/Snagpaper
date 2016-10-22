package com.simjes.snagpaper.imagedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.simjes.snagpaper.R;

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
    private static final String IMAGE_LINK = "imageLink";
    private String imageLink;

    public ImageDetailsFragment() {
    }

    public static ImageDetailsFragment newInstance(String imageLink) {
        ImageDetailsFragment fragment = new ImageDetailsFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_LINK, imageLink);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLink = getArguments().getString(IMAGE_LINK);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_details, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(getContext()).load(imageLink).into(imageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
