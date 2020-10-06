package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


public class brightnessservice extends Service {
    private static final String TAG = "SeamTestApp-Brightness";
    public EditText editText;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {

        super.onCreate();
        Log.d(TAG,"Brightness Test Service Created" );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Brightness Test Service started" );
        ContentResolver contentResolver = this.getContentResolver();
        String brightnessText;
        brightnessText = intent.getExtras().getString("editText");
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, Integer.parseInt(brightnessText));
        Toast.makeText(this, "Brightness Set to " + brightnessText, Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Brightness Test Service destroyed" );
        super.onDestroy();
        Toast.makeText(this, "Brightness Test Service destroyed", Toast.LENGTH_LONG).show();

    }

}
