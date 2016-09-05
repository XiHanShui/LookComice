package com.android.wujie.lookcomics.ui.fragment.feed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.wujie.lookcomics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {


    public static FeedFragment newInstance() {
        return new FeedFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.feed_fragment, container, false);
    }

}
