package com.android.wujie.lookcomics.presenter.feedpresenter;

import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;

/**
 * Created by TF on 2016/9/6.
 */
public interface IFeedPresenter {

    void  queryFeedSquareHotData();
    public interface ICallBack{
        void callback(FeedSquareHotBean bean);
    }
}
