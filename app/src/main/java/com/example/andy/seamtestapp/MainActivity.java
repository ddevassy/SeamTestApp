package com.example.andy.seamtestapp;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mediastart, mediastop, checkwlan;
    private static final String TAG = "SeamTestApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediastart = (Button) findViewById(R.id.buttonAudioStart);
        mediastop = (Button) findViewById(R.id.buttonAudioStop);
        checkwlan = (Button) findViewById(R.id.buttonWifi);

        mediastart.setOnClickListener(this);
        mediastop.setOnClickListener(this);
        checkwlan.setOnClickListener(this);
        Log.d(TAG,"On onCreate" );

    }

    @Override
    public void onClick(View view) {
        if(view==mediastart) {
            startService(new Intent(this, service.class));
            Log.d(TAG,"Pressed Audio Test Start Button" );
        } else if (view == mediastop) {
            stopService(new Intent(this, service.class));
            Log.d(TAG,"Pressed Audio Test Stop Button" );
        } else if (view == checkwlan) {
            Log.d(TAG,"Pressed Wlan Test Button" );
            startService(new Intent(this, wlanservice.class));
        }
    }

}
