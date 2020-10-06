package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class volumeservice extends Service {
    AudioManager audioManager;
    private static final String TAG = "SeamTestApp-Volume";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Volume Mute Service Test started" );
        ContentResolver contentResolver = this.getContentResolver();
        int originalMode = audioManager.getMode();
        Toast.makeText(this, "Before Volume State " + originalMode, Toast.LENGTH_LONG).show();
        audioManager.setMode(AudioManager.MODE_NORMAL);
        boolean state = !audioManager.isMicrophoneMute();

        audioManager.setMicrophoneMute(state);

        Toast.makeText(this, "After Volume Set to " + state, Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Volume Service Test destroyed" );
        super.onDestroy();
        Toast.makeText(this, "Volume Service Test destroyed", Toast.LENGTH_LONG).show();

    }
}
