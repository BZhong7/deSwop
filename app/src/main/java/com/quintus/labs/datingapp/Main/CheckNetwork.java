package com.quintus.labs.datingapp.Main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckNetwork extends AsyncTask<Context, Void, Void> {

    final String LOG_TAG = this.getClass().getSimpleName();

    private Context mContext;
    private FileWriter fileWriter = new FileWriter();

    protected Void doInBackground(Context... params) {
        if (checkActiveInternetConnection()) {
            fileWriter.writeToFile("There is a network connection", mContext);
        }
        else {
            fileWriter.writeToFile("Cannot connect to internet", mContext);
        }
        return null;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            // Network is present and connected
            isAvailable = true;
        }
        return isAvailable;
    }

    public boolean checkActiveInternetConnection() {
        if (isNetworkAvailable()) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error: ", e);
            }
        } else {
            Log.d(LOG_TAG, "No network present");
        }
        return false;
    }
}
