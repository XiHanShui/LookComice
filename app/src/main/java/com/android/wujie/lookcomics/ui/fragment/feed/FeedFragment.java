package com.android.wujie.lookcomics.ui.fragment.feed;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.wujie.lookcomics.R;
import com.android.wujie.lookcomics.adapter.feed.FeedViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {



    private List<Fragment> mFragments = new ArrayList<>();//存储fragment的容器
    private Context mContext;
    private AppCompatActivity mActivity;
    private FeedViewPageAdapter mFeedViewPageAdapter;

    /**
     * @return 工厂方法获得fragment的对象
     */
    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mActivity = (AppCompatActivity) getActivity();
        loadFragment();

    }

    private void loadFragment() {
        mFragments.add(FeedAttentionFragment.newInstance());
        mFragments.add(FeedSquareFragment.newInstance());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_fragment, container, false);
        return view;
    }


}
