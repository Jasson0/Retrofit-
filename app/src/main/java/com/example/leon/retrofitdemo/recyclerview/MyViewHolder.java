package com.example.leon.retrofitdemo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leon.retrofitdemo.R;

/**
 * Created by leon on 2018/5/10.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.name);
    }
}
