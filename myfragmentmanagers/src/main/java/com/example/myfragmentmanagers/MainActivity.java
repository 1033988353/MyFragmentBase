package com.example.myfragmentmanagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
//                activity向fragment通讯
                Bundle bundle = new Bundle();
                bundle.putString("message", "I like it");
                BlankFragment1 blankFragment1 = new BlankFragment1();
                blankFragment1.setArguments(bundle);
                blankFragment1.setiFragmentCallback(new IFragmentCallback() {
                    @Override
                    public void sendMsgActivity(String str) {
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String getMsgFromActivity(String str) {
                        return "send by activity";
                    }
                });
                replaceFragment(blankFragment1);
                break;
            case R.id.button2:
                replaceFragment(new ItemFragment());
                break;
        }
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        //加入栈按返回不会直接退出而是返回上一步
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}