package com.example.nemzs.homework3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;

/**
 * Created by Nemzs on 30.11.2016.
 */
public class MyBroadCastReceiver extends BroadcastReceiver {
    @MainThread
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ImageLoaderService.class).putExtra("uri", MainActivity.uri));
    }

}
