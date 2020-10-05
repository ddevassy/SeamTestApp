package com.example.andy.seamtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mediastart, mediastop, checkwlan, checknw, syncprovision, syncdeprovision;
    private static final String TAG = "SeamTestApp";

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


        mediastart.setOnClickListener(this);
        mediastop.setOnClickListener(this);
        checkwlan.setOnClickListener(this);
        checknw.setOnClickListener(this);
        syncprovision.setOnClickListener(this);
        syncdeprovision.setOnClickListener(this);
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
        }else if (view == syncprovision) {
            Log.d(TAG,"Pressed Sync Provision Test Button" );
            startService(new Intent(this, syncservice.class));
        }else if (view == syncdeprovision) {
            Log.d(TAG,"Pressed Sync DeProvision Test Button" );
            startService(new Intent(this, syncservice.class));
        }
    }

}
