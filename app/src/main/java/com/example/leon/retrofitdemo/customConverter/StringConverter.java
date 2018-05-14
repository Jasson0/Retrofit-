package com.example.leon.retrofitdemo.customConverter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by leon on 2018/5/10.
 */

public class StringConverter implements Converter<ResponseBody, String> {
    public static final StringConverter INSTANCE = new StringConverter();

    @Override
    public String convert(ResponseBody value) throws IOException {
        return value.string();
    }
}
