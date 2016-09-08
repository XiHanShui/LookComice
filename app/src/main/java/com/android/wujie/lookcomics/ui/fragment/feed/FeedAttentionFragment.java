package com.android.wujie.lookcomics.ui.fragment.feed;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.wujie.lookcomics.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedAttentionFragment extends Fragment {


    @BindView(R.id.feedsquare_hot)
    TabLayout feedsquareHot;
    @BindView(R.id.feedsquare_vp)
    ViewPager feedsquareVp;

    public static FeedAttentionFragment newInstance() {
        return new FeedAttentionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_square_hot_fragment, container, false);
        ButterKnife.bind(this, view);
//        feedsquareHot.setupWithViewPager(feedsquareVp);

        return view;
    }

}
