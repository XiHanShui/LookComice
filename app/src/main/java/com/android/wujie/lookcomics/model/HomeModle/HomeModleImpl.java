package com.android.wujie.lookcomics.model.HomeModle;

import com.android.wujie.lookcomics.bean.home.HomeBean;
import com.android.wujie.lookcomics.httputils.HttpUtils;
import com.android.wujie.lookcomics.presenter.homepresenter.IHomePresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by TF on 2016/9/5.
 */
public class HomeModleImpl implements IHomeModle {
    /**
     * @param callBack
     * 加载home界面 today数据
     */
    @Override
    public void queryHomeList(final IHomePresenter.ICallBack callBack) {
        HttpUtils.creat().queryHomeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeBean>() {
                    @Override
                    public void call(HomeBean bean) {
                        callBack.callback(bean);
                    }
                });
    }
}
