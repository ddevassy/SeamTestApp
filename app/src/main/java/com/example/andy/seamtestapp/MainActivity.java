package com.example.andy.seamtestapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mediastart, mediastop, checkwlan, checknw, syncprovision, syncdeprovision, brightness, mutevolume, unmutevolume;
    private static final String TAG = "SeamTestApp";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediastart = (Button) findViewById(R.id.buttonAudioStart);
        mediastop = (Button) findViewById(R.id.buttonAudioStop);
        checkwlan = (Button) findViewById(R.id.buttonWifi);
        checknw = (Button) findViewById(R.id.buttonNW);
        syncprovision = (Button) findViewById(R.id.buttonProvision);
        syncdeprovision = (Button) findViewById(R.id.buttonDeProvision);
        brightness = (Button) findViewById(R.id.buttonBrightness);
        mutevolume = (Button) findViewById(R.id.buttonMute);
        unmutevolume = (Button) findViewById(R.id.buttonUnMute);

        mediastart.setOnClickListener(this);
        mediastop.setOnClickListener(this);
        checkwlan.setOnClickListener(this);
        checknw.setOnClickListener(this);
        syncprovision.setOnClickListener(this);
        syncdeprovision.setOnClickListener(this);
        brightness.setOnClickListener(this);
        mutevolume.setOnClickListener(this);
        unmutevolume.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editBrightness);

        Log.d(TAG,"On onCreate" );

    }

    @Override
    public void onClick(View view) {
        if(view==mediastart) {
            startService(new Intent(this, audioservice.class));
            Log.d(TAG,"Pressed Audio Test Start Button" );
        } else if (view == mediastop) {
            stopService(new Intent(this, audioservice.class));
            Log.d(TAG,"Pressed Audio Test Stop Button" );
        } else if (view == checkwlan) {
            Log.d(TAG,"Pressed Wlan Test Button" );
            startService(new Intent(this, wlanservice.class));
        } else if (view == checknw) {
            Log.d(TAG,"Pressed NetWork Test Button" );
            startService(new Intent(this, networkservice.class));
        } else if (view == syncprovision) {
            Log.d(TAG,"Pressed Sync Provision Test Button" );
            startService(new Intent(this, syncservice.class));
        } else if (view == syncdeprovision) {
            Log.d(TAG,"Pressed Sync DeProvision Test Button" );
            startService(new Intent(this, syncservice.class));
        } else if (view == brightness) {
            Log.d(TAG,"Pressed brightness Test Button" );
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.System.canWrite(this)) {
                    Log.d(TAG,"Already have the permission for Brightness" );
                } else {
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    intent.setData(Uri.parse("package:" + this.getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Log.d(TAG,"Setting up permission for Brightness" );
                }
            }
            Intent intent = new Intent(this, brightnessservice.class);
            intent.putExtra("editText", editText.getText().toString());
            startService(intent);
        } else if (view == mutevolume) {
            Log.d(TAG,"Pressed Mute volume Test Button" );
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.System.canWrite(this)) {
                    Log.d(TAG,"Already have the permission for Volume" );
                } else {
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    intent.setData(Uri.parse("package:" + this.getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Log.d(TAG,"Setting up permission for Volume" );
                }
            }
            Intent intent = new Intent(this, volumeservice.class);
            startService(intent);
        } else if (view == unmutevolume) {
            Log.d(TAG,"Pressed volume Test Button" );
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.System.canWrite(this)) {
                    Log.d(TAG,"Already have the permission for Volume" );
                } else {
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    intent.setData(Uri.parse("package:" + this.getPackageName()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Log.d(TAG,"Setting up permission for Volume" );
                }
            }
            Intent intent = new Intent(this, volumeservice.class);
            stopService(intent);
        }
    }
}
