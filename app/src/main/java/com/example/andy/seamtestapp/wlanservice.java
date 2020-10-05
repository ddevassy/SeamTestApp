package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.net.wifi.WifiManager;
import android.content.Context;
import android.widget.Toast;


public class wlanservice extends Service {
    private static final String TAG = "SeamTestApp-Wlan";
    WifiManager wifiManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        super.onCreate();
        Log.d(TAG,"WLAN Test Service Created" );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"WLAN Test Service started" );

        int rssi = wifiManager.getConnectionInfo().getRssi();
        int level = WifiManager.calculateSignalLevel(rssi,5);
        String ssid = wifiManager.getConnectionInfo().getSSID();
        String MacAddr = wifiManager.getConnectionInfo().getMacAddress();
        Toast.makeText(this, ("\t\tSignal Strength of "+ ssid+"\n\n\t\tMac Address = "+ MacAddr+"\n\n\t\tRSSI = "+ rssi + " dbm \n\n\t\tLevel = "+ level + " out of 5"), Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"WLAN Test Service destroyed" );
        super.onDestroy();
        Toast.makeText(this, "WLAN Test Service destroyed", Toast.LENGTH_LONG).show();

    }
}
