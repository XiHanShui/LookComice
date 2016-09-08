package com.android.wujie.lookcomics.ui.fragment.discover;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.wujie.lookcomics.R;
import com.android.wujie.lookcomics.bean.home.HomeBean;
import com.android.wujie.lookcomics.presenter.homepresenter.HomePresenterImpl;
import com.android.wujie.lookcomics.presenter.homepresenter.IHomePresenter;
import com.android.wujie.lookcomics.view.homeview.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisCoverFragment extends Fragment implements IHomeView {
    private IHomePresenter mIHomePresenter;
    private List<HomeBean.DataBean.ComicsBean> mComicsBeanList = new ArrayList<>();

    public static DisCoverFragment newInstance() {
        return new DisCoverFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIHomePresenter = new HomePresenterImpl(this);
        mIHomePresenter.queryHomePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dis_cover_fragment, container, false);
    }

    @Override
    public void refreshHomeData(List<HomeBean.DataBean.ComicsBean> comicsBeen) {
        mComicsBeanList.addAll(comicsBeen);
    }
}
