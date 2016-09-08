package com.android.wujie.lookcomics.adapter.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.wujie.lookcomics.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TF on 2016/9/6.
 */
public class FeedSquareHotGrideAdapter extends BaseAdapter {
    private List<String> mList;
    private String url_base;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedSquareHotGrideAdapter(List<String> list, String url_base, Context context) {
        mList = list;
        this.url_base = url_base;
        mContext = context;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.feed_square_hot_gridview, parent, false);
            holder = new ViewHolder(convertView);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Picasso.with(mContext).load(url_base+mList.get(position)).into(holder.feedSquareHotGridItem);
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.feed_square_hot_grid_item)
        ImageView feedSquareHotGridItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
