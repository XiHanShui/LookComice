package com.android.wujie.lookcomics.httputils;

import com.android.wujie.lookcomics.api.CommonApi;
import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;
import com.android.wujie.lookcomics.bean.home.HomeBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by TF on 2016/9/5.
 */
public interface IHttpService {
    /**
     * @return 获取漫画界面 --》today数据
     */
    @GET(CommonApi.TODAY)
    Observable<HomeBean> queryHomeData();

    /**
     * @return
     * V社区--》广场--》热门
     */
    @GET(CommonApi.feed_square_hot)
    Observable<FeedSquareHotBean> queryFeedSquareyHotData();

}
