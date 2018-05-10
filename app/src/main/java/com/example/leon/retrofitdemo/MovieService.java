package com.example.leon.retrofitdemo;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by leon on 2018/5/9.
 */

public interface MovieService {
    @GET("top250")
    Observable<MovieSubject2> getTop250(@Query("start") int start, @Query("count") int count);

    @FormUrlEncoded
    @POST("top250")
    Call<MovieSubject> getTop2502(@Field("start") int start, @Field("count") int count);
//    Call<MovieSubject2> getTop250(@Query("start") int start, @Query("count") int count);
}
