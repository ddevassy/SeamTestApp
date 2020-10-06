package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Volume Mute Service Test started" );

        audioManager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_PLAY_SOUND);

        Toast.makeText(this, "After Volume Set to " + AudioManager.ADJUST_MUTE, Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onDestroy() {
        Log.d(TAG,"Volume UnMute Service Test destroyed" );
        super.onDestroy();
        audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_PLAY_SOUND);
        Toast.makeText(this, "Volume Service Test destroyed", Toast.LENGTH_LONG).show();

    }
}
