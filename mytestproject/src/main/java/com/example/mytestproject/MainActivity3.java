package com.example.mytestproject;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void stopService_(View view) {
        stopService(new Intent(this, MyService.class));
    }


    public void startService_(View view) {
        startService(new Intent(this, MyService.class));

    }

    private ServiceConnection connecton = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void bindService_(View view) {
        bindService(new Intent(this, MyService.class), connecton, Context.BIND_AUTO_CREATE);
    }

    public void unbindService_(View view) {
        unbindService(connecton);
    }

    //    当此Activity被销毁的时候自动解绑
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connecton);
    }
}
