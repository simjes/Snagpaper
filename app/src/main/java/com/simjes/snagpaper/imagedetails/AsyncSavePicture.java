package com.simjes.snagpaper.imagedetails;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.simjes.snagpaper.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;

//TODO: change to RxJava?
public class AsyncSavePicture extends AsyncTask<String, Void, Boolean> {
    private Context context;

    public AsyncSavePicture(Context context) {
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(String... imageDetails) {
        FileOutputStream outstream = null;
        try {
            Bitmap imageToSave = Glide.with(context).load(imageDetails[0]).asBitmap().into(-1, 1).get();
            if(isExternalStorageWritable()) {
                File saveTo = new File(getAlbumStorageDir(Constants.PICTURE_DIR), imageDetails[1] + ".png");
                outstream = new FileOutputStream(saveTo);
                imageToSave.compress(Bitmap.CompressFormat.PNG, 100, outstream);
                return true;
            }
        } catch (InterruptedException | ExecutionException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean imageSaved) {
        //TODO: better error message and onProgress?
        if (imageSaved) {
            Toast.makeText(context, "Image saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Could not save image", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    private String getAlbumStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(Constants.LOG_TAG, "Directory not created");
        }
        return file.getAbsolutePath();
    }
}
