package com.example.nemzs.homework3;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nemzs on 30.11.2016.
 */
public class ImageLoaderService extends IntentService {
    public ImageLoaderService(){
        super("ImageLoaderService");
    }
    @Override
    protected void onHandleIntent(Intent intent){
        try {
            URL url = new URL(intent.getStringExtra("uri"));
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            FileOutputStream fout = openFileOutput("image2.jpg", Context.MODE_PRIVATE);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fout);
            fout.close();
            sendBroadcast(new Intent(MainActivity.BROADCAST_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
