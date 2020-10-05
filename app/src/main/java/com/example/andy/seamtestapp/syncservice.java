package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class syncservice extends Service {
    private static final String TAG = "SeamTestApp-Sync";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Sync Service Test started" );
        Toast.makeText(this, "Sync Service Test - NotImplemented", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Sync Service Test destroyed" );
        super.onDestroy();
        Toast.makeText(this, "Sync Service Test - NotImplemented", Toast.LENGTH_LONG).show();

    }
}
