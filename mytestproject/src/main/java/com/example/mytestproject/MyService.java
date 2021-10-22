package com.example.mytestproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private static final String TAG = MyService.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, TAG + " onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, TAG + " onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, TAG + " onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, TAG + " onDestroy");

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, TAG + " onUnbind");
        return super.onUnbind(intent);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, TAG + " onBind");
        return null;
    }
}
