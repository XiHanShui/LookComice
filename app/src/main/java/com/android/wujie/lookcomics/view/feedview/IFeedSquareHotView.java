package com.android.wujie.lookcomics.view.feedview;

import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;

import java.util.List;

/**
 * Created by TF on 2016/9/6.
 */
public interface IFeedSquareHotView {
    void refreshFeedSquareHotData(List<FeedSquareHotBean.DataBean.FeedsBean> feedsBeen);
}
