package com.example.leon.retrofitdemo.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.leon.retrofitdemo.MovieSubject2;
import com.example.leon.retrofitdemo.R;

/**
 * Created by leon on 2018/5/10.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private MovieSubject2 movieSubjectList = new MovieSubject2();
    private Context context;

    public void setMovies(MovieSubject2 movieSubjectList) {
        this.movieSubjectList = movieSubjectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemContent = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        context = parent.getContext();
        MyViewHolder myViewHolder = new MyViewHolder(itemContent);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context)
                .load(movieSubjectList.getSubjects().get(position).getImages().getSmall())
                .into(holder.imageView);
        holder.textView.setText(movieSubjectList.getSubjects().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieSubjectList.getCount();
    }
}
