package com.android.wujie.lookcomics.httputils;

import com.android.wujie.lookcomics.api.CommonApi;

import java.util.logging.MemoryHandler;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.*;

/**
 * Created by TF on 2016/9/5.
 */
public class HttpUtils {
    private static IHttpService mHttpService;

    public static IHttpService creat() {
        if (mHttpService == null) {
            Retrofit builder = new Retrofit.Builder()
                    .baseUrl(CommonApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mHttpService=builder.create(IHttpService.class);

        }
        return mHttpService;

    }

}
