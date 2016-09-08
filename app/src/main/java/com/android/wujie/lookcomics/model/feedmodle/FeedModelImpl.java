package com.android.wujie.lookcomics.model.feedmodle;

import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;
import com.android.wujie.lookcomics.httputils.HttpUtils;
import com.android.wujie.lookcomics.presenter.feedpresenter.IFeedPresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by TF on 2016/9/6.
 */
public class FeedModelImpl implements IFeedModle {
    /**
     * @param callBack
     * 请求得到V社区--》广场--》热门 数据
     * 回调数据到presenter层
     */
    @Override
    public void queryFeedData(final IFeedPresenter.ICallBack callBack) {
        HttpUtils.creat().queryFeedSquareyHotData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<FeedSquareHotBean>() {
                    @Override
                    public void call(FeedSquareHotBean bean) {
                        callBack.callback(bean);
                    }
                });
    }
}
