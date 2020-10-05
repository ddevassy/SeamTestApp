package com.example.andy.seamtestapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class networkservice extends Service {
    private static final String TAG = "SeamTestApp-Network";
    ConnectivityManager connManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        try {
            connManager = (ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        } catch (RuntimeException e){
            Log.e(TAG,"Unable to Connect");
            Toast.makeText(this, ("\t\tNo Internet Connection"), Toast.LENGTH_LONG).show();
        }
        super.onCreate();
        Log.d(TAG,"Network Test Service Created" );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Log.d(TAG,"Network Test Service started" );
            NetworkInfo activeNetwork = connManager.getActiveNetworkInfo();

            Toast.makeText(this, ("\t\tDetailed State "+ activeNetwork.getDetailedState() + "\n\n\t\tExtraInfo "+ activeNetwork.getExtraInfo() ), Toast.LENGTH_LONG).show();
        } catch (RuntimeException e) {
            Log.e(TAG,"Unable to Connect to Inernet");
            Toast.makeText(this, ("\t\tNo Internet Connection"), Toast.LENGTH_LONG).show();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Network Test Service destroyed" );
        super.onDestroy();
        Toast.makeText(this, "Network Test Service destroyed", Toast.LENGTH_LONG).show();

    }
}
