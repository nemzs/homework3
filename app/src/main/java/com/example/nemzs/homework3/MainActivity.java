package com.example.nemzs.homework3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {
    ImageView myFirstImage;
    TextView status;
    public static String uri = "http://i40.beon.ru/13/60/2646013/75/105861175/PhoenixAshes.jpeg";
    public final static String BROADCAST_NAME = "ru.startandroid.develop.nemzs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFirstImage = (ImageView) findViewById(R.id.imageView);
        status = (TextView) findViewById(R.id.status);

        final String fileName = getFilesDir().getPath() + "/image2.jpg";
        BroadcastReceiver br = new BroadcastReceiver() {
            // действия при получении сообщений
            public void onReceive(Context context, Intent intent) {
                File file = new File(fileName);
                myFirstImage.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
                myFirstImage.setVisibility(View.VISIBLE);
                status.setVisibility(View.GONE);
            }
        };

        File file = new File(fileName);
        if (file.exists()) {
            myFirstImage.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
            myFirstImage.setVisibility(View.VISIBLE);
            status.setVisibility(View.GONE);
        }
        IntentFilter intFilt = new IntentFilter(BROADCAST_NAME);
        // регистрируем (включаем) BroadcastReceiver
        registerReceiver(br, intFilt);
        }

    }
