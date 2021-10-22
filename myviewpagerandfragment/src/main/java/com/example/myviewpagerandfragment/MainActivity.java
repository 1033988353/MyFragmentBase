package com.example.myviewpagerandfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager2.setAdapter(viewPagerAdapter);
    }
}