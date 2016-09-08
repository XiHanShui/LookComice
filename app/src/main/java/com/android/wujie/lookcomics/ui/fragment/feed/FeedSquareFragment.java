package com.android.wujie.lookcomics.ui.fragment.feed;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.wujie.lookcomics.R;
import com.android.wujie.lookcomics.adapter.feed.FeedViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedSquareFragment extends Fragment {


    @BindView(R.id.feed_square_tab)
    TabLayout feedSquareTab;
    @BindView(R.id.feed_square_vp)
    ViewPager feedSquareVp;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mList=new ArrayList<>();
    private AppCompatActivity mActivity;

    public static FeedSquareFragment newInstance() {
        return new FeedSquareFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (AppCompatActivity) getActivity();
        loadFragment();
    }

    private void loadFragment() {
        mFragments.add(FeedSquareHotFragment.newInstance());
        mFragments.add(FeedSquareLastFragment.newInstance());
        mList.add("热门");
        mList.add("最新");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_square_fragment, container, false);
        ButterKnife.bind(this, view);
        feedSquareTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        initAdapter();
        feedSquareTab.setupWithViewPager(feedSquareVp);

        return view;
    }



    private void initAdapter() {

        FeedViewPageAdapter feedViewPageAdapter = new FeedViewPageAdapter(mActivity.getSupportFragmentManager(), mFragments,mList);
        feedSquareVp.setAdapter(feedViewPageAdapter);
    }

}
