package com.example.wechatpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager2 viewPager;
    private ImageView ivChat, ivPredict, ivSearch, ivMine, ivCurrent;
    private LinearLayout llChat, llPredict, llSearch, llMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initTableView();
    }

    private void initTableView() {
        llChat = findViewById(R.id.id_table_chat);
        llChat.setOnClickListener(this);
        llPredict = findViewById(R.id.id_table_predict);
        llPredict.setOnClickListener(this);
        llSearch = findViewById(R.id.id_table_search);
        llSearch.setOnClickListener(this);
        llMine = findViewById(R.id.id_table_mine);
        llMine.setOnClickListener(this);
        ivChat = findViewById(R.id.table_chat);
        ivPredict = findViewById(R.id.table_predict);
        ivSearch = findViewById(R.id.table_search);
        ivMine = findViewById(R.id.table_mine);
        ivChat.setSelected(true);
        ivCurrent = ivChat;
    }

    private void initPager() {
        viewPager = findViewById(R.id.id_viewpager);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(BlankFragment.newInstance("chat"));
        fragmentList.add(BlankFragment.newInstance("search"));
        fragmentList.add(BlankFragment.newInstance("predict"));
        fragmentList.add(BlankFragment.newInstance("mine"));
        MyFragmentStateAdapter myFragmentStateAdapter = new MyFragmentStateAdapter(
                getSupportFragmentManager(), getLifecycle(), fragmentList);
        viewPager.setAdapter(myFragmentStateAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTable(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTable(int position) {
        ivCurrent.setSelected(false);
        switch (position) {
            case R.id.id_table_chat:
                viewPager.setCurrentItem(0);
            case 0:
                ivChat.setSelected(true);
                ivCurrent = ivChat;
                break;
            case R.id.id_table_search:
                viewPager.setCurrentItem(1);
            case 1:
                ivSearch.setSelected(true);
                ivCurrent = ivSearch;
                break;
            case R.id.id_table_predict:
                viewPager.setCurrentItem(2);
            case 2:
                ivPredict.setSelected(true);
                ivCurrent = ivPredict;
                break;
            case R.id.id_table_mine:
                viewPager.setCurrentItem(3);
            case 3:
                ivMine.setSelected(true);
                ivCurrent = ivMine;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTable(view.getId());
    }
}