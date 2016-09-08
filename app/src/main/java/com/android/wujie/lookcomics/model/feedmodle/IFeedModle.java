package com.android.wujie.lookcomics.model.feedmodle;

import com.android.wujie.lookcomics.presenter.feedpresenter.IFeedPresenter;

/**
 * Created by TF on 2016/9/6.
 */
public interface IFeedModle {
    void queryFeedData(IFeedPresenter.ICallBack callBack);

}
