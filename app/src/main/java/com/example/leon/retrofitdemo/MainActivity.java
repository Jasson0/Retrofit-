package com.example.leon.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.leon.retrofitdemo.recyclerview.MyRecyclerAdapter;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_UTL = "https://api.douban.com/v2/movie/";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_UTL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.my_recyclerview);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        recyclerView.setLayoutManager(layoutmanager);
        final MyRecyclerAdapter adapter = new MyRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        //获取接口实例
        MovieService movieService = retrofit.create(MovieService.class);
        Subscription subscription = movieService.getTop250(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieSubject2>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieSubject2 movieSubject2) {
                        adapter.setMovies(movieSubject2);
                        adapter.notifyDataSetChanged();
                    }
                });
        //进行网络请求
//        Call<MovieSubject2> call = movieService.getTop250(0, 20);
//        call.enqueue(new Callback<MovieSubject2>() {
//            @Override
//            public void onResponse(Call<MovieSubject2> call, Response<MovieSubject2> response) {
//                adapter.setMovies(response.body());
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<MovieSubject2> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }
}
