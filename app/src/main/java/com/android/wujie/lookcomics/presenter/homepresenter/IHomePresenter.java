package com.android.wujie.lookcomics.presenter.homepresenter;

import com.android.wujie.lookcomics.bean.homebean.HomeBean;

/**
 * Created by TF on 2016/9/5.
 */
public interface IHomePresenter {
    void queryHomePresenter();

    public interface ICallBack {
        void callback(HomeBean bean);
    }
}
