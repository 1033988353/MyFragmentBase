package com.example.myspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner_one;
    private Spinner spinner_two;
    private Context mContext;
    private boolean one_Selected = false;
    private boolean two_Selected = false;
    private ArrayList<Hero> mData = null;
    private SpinnerAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mData = new ArrayList<Hero>();
        bindViews();
    }

    private void bindViews() {
        spinner_one = (Spinner) findViewById(R.id.spinner_one);
        spinner_two = (Spinner) findViewById(R.id.spinner_two);
        mData.add(new Hero(R.drawable.hero1, "寒冰射手 艾希"));
        mData.add(new Hero(R.drawable.hero2, "黑暗之女 安妮"));
        mData.add(new Hero(R.drawable.hero3, "皎月女神 戴安娜"));
        mData.add(new Hero(R.drawable.hero4, "疾风剑豪 亚索"));
        mData.add(new Hero(R.drawable.hero5, "盲僧 李青"));
        mData.add(new Hero(R.drawable.hero6, "无双剑姬 菲奥娜"));
        myAdapter = new MySpinnerAdapter(mData, mContext);
        spinner_two.setAdapter(myAdapter);
        spinner_one.setOnItemSelectedListener(this);
        spinner_two.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (adapterView.getId()) {
            case R.id.spinner_one:
                if (one_Selected) {
                    Toast.makeText(mContext, "your rank is：" + adapterView.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    one_Selected = true;
                }
                break;
            case R.id.spinner_two:
                if (two_Selected) {
                    TextView textView = (TextView) view.findViewById(R.id.hero_name);
                    Toast.makeText(mContext, "您选择的英雄是~：" + textView.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    two_Selected = true;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}