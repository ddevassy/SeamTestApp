package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;



public class audioservice extends Service {
    MediaPlayer musicPlayer;
    private static final String TAG = "SeamTestApp-Audio";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer = MediaPlayer.create(this, R.raw.abc);
        musicPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Audio Service Test started" );
        Toast.makeText(this, "Audio Service Test started", Toast.LENGTH_LONG).show();
        musicPlayer.setLooping(true);
        musicPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Audio Service Test destroyed" );
        super.onDestroy();
        musicPlayer.stop();
        Toast.makeText(this, "Audio Service Test destroyed", Toast.LENGTH_LONG).show();

    }
}
