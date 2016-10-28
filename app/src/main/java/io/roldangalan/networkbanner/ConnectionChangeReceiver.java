package io.roldangalan.networkbanner;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by Roldán Galán on 20/10/2016.
 */

public class ConnectionChangeReceiver extends BroadcastReceiver {
    private final MainActivity activity;

    public ConnectionChangeReceiver(MainActivity activity) {
        this.activity = activity;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(MainActivity.TAG, "ConnectionChangeReceiver.onReceive()");
        if (activity != null) activity.networkStateChange(hasInternet(context));
    }

    private static boolean hasInternet(Activity activity) {
        return hasInternet(activity.getApplicationContext());
    }

    private static boolean hasInternet(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isOnline = (networkInfo != null && networkInfo.isConnected());

        return isOnline;
    }
}
