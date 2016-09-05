package com.android.wujie.lookcomics.httputils;

import com.android.wujie.lookcomics.api.CommonApi;
import com.android.wujie.lookcomics.bean.homebean.HomeBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by TF on 2016/9/5.
 */
public interface IHttpService {
@GET(CommonApi.TODAY)
Observable<HomeBean> queryHomeData();

}
