package com.android.wujie.lookcomics.presenter.feedpresenter;

import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;
import com.android.wujie.lookcomics.model.feedmodle.FeedModelImpl;
import com.android.wujie.lookcomics.model.feedmodle.IFeedModle;
import com.android.wujie.lookcomics.view.feedview.IFeedSquareHotView;

import java.util.List;

/**
 * Created by TF on 2016/9/6.
 */
public class FeedPresenterImpl implements IFeedPresenter ,IFeedPresenter.ICallBack {
   private IFeedModle mIFeedModle;
    private IFeedSquareHotView mHotView;

    public FeedPresenterImpl(IFeedSquareHotView hotView) {
        mHotView = hotView;
        mIFeedModle=new FeedModelImpl();
    }

    @Override
    public void queryFeedSquareHotData() {
mIFeedModle.queryFeedData(this);
    }

    @Override
    public void callback(FeedSquareHotBean bean) {
        List<FeedSquareHotBean.DataBean.FeedsBean> feeds = bean.getData().getFeeds();
        mHotView.refreshFeedSquareHotData(feeds);
    }
}
