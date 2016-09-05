package com.android.wujie.lookcomics.view.homeview;

import com.android.wujie.lookcomics.bean.homebean.HomeBean;

import java.util.List;

/**
 * Created by TF on 2016/9/5.
 */
public interface IHomeView {

    void refreshHomeData(List<HomeBean.DataBean.ComicsBean> comicsBeen);
}
