package com.android.wujie.lookcomics.adapter.feed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by TF on 2016/9/5.
 * V社区界面 viewpage适配器
 */
public class FeedViewPageAdapter extends FragmentPagerAdapter {
    private List<String> mList;
    private List<Fragment> mFragments;

    public FeedViewPageAdapter(FragmentManager fm, List<Fragment> mFragments, List<String> mList) {
        super(fm);
        this.mFragments = mFragments;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
