package com.android.wujie.lookcomics.presenter.homepresenter;

import com.android.wujie.lookcomics.bean.homebean.HomeBean;
import com.android.wujie.lookcomics.model.HomeModle.HomeModleImpl;
import com.android.wujie.lookcomics.model.HomeModle.IHomeModle;
import com.android.wujie.lookcomics.view.homeview.IHomeView;

import java.util.List;

/**
 * Created by TF on 2016/9/5.
 */
public class HomePresenterImpl implements IHomePresenter, IHomePresenter.ICallBack {
    private IHomeModle mHomeModle;
    private IHomeView mHomeView;

    public HomePresenterImpl(IHomeView homeView) {
        mHomeModle = new HomeModleImpl();
        this.mHomeView = homeView;
    }

    @Override
    public void queryHomePresenter() {
        mHomeModle.queryHomeList(this);
    }

    @Override
    public void callback(HomeBean bean) {
        List<HomeBean.DataBean.ComicsBean> comics = bean.getData().getComics();
        mHomeView.refreshHomeData(comics);
    }
}
