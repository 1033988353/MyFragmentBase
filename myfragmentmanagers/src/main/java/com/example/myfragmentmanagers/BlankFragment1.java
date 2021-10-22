package com.example.myfragmentmanagers;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 * 打开界面会运行生命周期
 * oncreate oncreateview onactivitycreated onstart onresume
 * 按下主屏键
 * onpause onstop
 * 重新打开界面
 * onstart onresume
 * 按后退键
 * onpause onstop ondestroyview ondestroy ondetach
 */
public class BlankFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "BlankFragment1";
    private IFragmentCallback iFragmentCallback;
    private View rootview;

    public IFragmentCallback getiFragmentCallback() {
        return iFragmentCallback;
    }

    public void setiFragmentCallback(IFragmentCallback iFragmentCallback) {
        this.iFragmentCallback = iFragmentCallback;
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        Log.e(TAG, "onCreate：" + bundle.getString("message"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (rootview == null) {
            rootview = inflater.inflate(R.layout.fragment_blank1, container, false);
        }
        Button button = rootview.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iFragmentCallback.sendMsgActivity("yes, it seem nice.");
                Toast.makeText(BlankFragment1.this.getContext(),
                        iFragmentCallback.getMsgFromActivity("null"),
                        Toast.LENGTH_SHORT).show();
            }
        });
        Log.e(TAG, "onCreateView");
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");

    }

    @Override
    public void onStop() {

        super.onStop();
        Log.e(TAG, "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach");

    }
}