package com.example.mytestproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class MainActivity4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
//        注册接收者
        UpdataIPSelectCity updataIPSelectCity = new UpdataIPSelectCity();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        registerReceiver(updataIPSelectCity, intentFilter);
    }

    //    静态发送给接收者
    public void sendAction2(View view) {
        Intent intent = new Intent();
        //setAction必须与注册时候保持一致，即在AndroidManifest中配置一致
        intent.setAction(ActionUtils.ACTION_FLAG);
        sendBroadcast(intent);
    }
    //    动态注册接收者发送给接收者
    public void sendAction1(View view) {
        Intent intent = new Intent();
        //setAction必须与注册时候保持一致，即在AndroidManifest中配置一致
        intent.setAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        sendBroadcast(intent);
    }
}