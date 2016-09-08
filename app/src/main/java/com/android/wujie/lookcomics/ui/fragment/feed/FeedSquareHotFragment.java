package com.android.wujie.lookcomics.ui.fragment.feed;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.wujie.lookcomics.R;
import com.android.wujie.lookcomics.adapter.feed.FeedSquareHotListAdapter;
import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;
import com.android.wujie.lookcomics.presenter.feedpresenter.FeedPresenterImpl;
import com.android.wujie.lookcomics.presenter.feedpresenter.IFeedPresenter;
import com.android.wujie.lookcomics.view.feedview.IFeedSquareHotView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedSquareHotFragment extends Fragment implements IFeedSquareHotView {


    @BindView(R.id.feed_square_hot_lv)
    ListView feedSquareHotLv;
    private IFeedPresenter mFeedPresenter;
    private  List<FeedSquareHotBean.DataBean.FeedsBean> mList=new ArrayList<>();
    private Context mContext;
    private FeedSquareHotListAdapter mAdapter;
    private ProgressDialog mProgressDialog;

    public static FeedSquareHotFragment newInstance() {
        return new FeedSquareHotFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        initDiaProess();
        mFeedPresenter = new FeedPresenterImpl(this);
        mFeedPresenter.queryFeedSquareHotData();
    }

    private void initDiaProess() {
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("请稍等");
        mProgressDialog.setMessage("玩命加载中");
        mProgressDialog.show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_square_hot_fragment1, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    private void initAdapter() {
        mAdapter = new FeedSquareHotListAdapter(mList,mContext);
    }

    @Override
    public void refreshFeedSquareHotData(List<FeedSquareHotBean.DataBean.FeedsBean> feedsBeen) {
        mList.addAll(feedsBeen);
//        mAdapter.notifyDataSetChanged();
        initAdapter();
        mProgressDialog.dismiss();
//        Log.d("FeedSquareHotFragment", "feedsBeen.size():" + feedsBeen.size());
    }
}
