package com.example.myviewpagerandfragment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
    private List<String> title = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();

    public ViewPagerAdapter() {
        title.add("hello");
        title.add("fine");
        title.add("thank");
        title.add("you");
        title.add("and");
        title.add("you");
        title.add("i");
        title.add("am");
        title.add("fine");
        title.add("too");
        colors.add(R.color.blue);
        colors.add(R.color.red);
        colors.add(R.color.green);
        colors.add(R.color.white);
        colors.add(R.color.sky_blue);
        colors.add(R.color.blue);
        colors.add(R.color.red);
        colors.add(R.color.green);
        colors.add(R.color.white);
        colors.add(R.color.sky_blue);
    }

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.mtextView.setText(title.get(position));
        holder.mContainer.setBackgroundResource(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewPagerHolder extends RecyclerView.ViewHolder {
        TextView mtextView;
        RelativeLayout mContainer;

        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container1);
            mtextView = itemView.findViewById(R.id.textview);
        }
    }
}
