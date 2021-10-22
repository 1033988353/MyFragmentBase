package com.example.mytestproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver{
    private static final String TAG = MyReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,TAG+" onReceive statically");
    }
}
