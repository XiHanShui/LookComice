package com.android.wujie.lookcomics.adapter.feed;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wujie.lookcomics.R;
import com.android.wujie.lookcomics.bean.feed.FeedSquareHotBean;
import com.android.wujie.lookcomics.customview.CustomGridView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by TF on 2016/9/6.
 */
public class FeedSquareHotListAdapter extends BaseAdapter{
    private List<FeedSquareHotBean.DataBean.FeedsBean> mList;
    private Context mContext;
    private LayoutInflater inflater;
//    private ImageView mUpAttention;
//    private CustomGridView mUpgridView;

    public FeedSquareHotListAdapter(List<FeedSquareHotBean.DataBean.FeedsBean> list, Context context) {
        this.mList = list;
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
//        Log.d("FeedSquareHotListAdapte", "mList.size():" + mList.size());
    }

    @Override
    public int getCount() {
        Log.d("FeedSquareHotListAdapte", "mList.size():" + mList.size());
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.feed_square_hot_item, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        FeedSquareHotBean.DataBean.FeedsBean feedsBean = mList.get(position);
        Log.d("FeedSquareHotListAdapte", "feedsBean.getCreated_at():" + feedsBean.getCreated_at());
//        设置作者头像
        Picasso.with(mContext).load(feedsBean.getUser().getAvatar_url()).into(holder.avatar_url);
//      设置作者昵称
        holder.nickname.setText(feedsBean.getUser().getNickname());
//     设置产品描述
        holder.text.setText(feedsBean.getContent().getText());
//      设置喜欢的数量加1
//        holder.add.setOnClickListener(this);
//        设置关注
        setupAttention(holder.add);
//        设置中间的GridView的图片
        String image_base = feedsBean.getContent().getImage_base();
        List<String> images = feedsBean.getContent().getImages();
//设置GridView 的数据
        setupgridView(holder.images,image_base,images);
        return convertView;
    }

    private void setupgridView(CustomGridView images, String image_base, List<String> image_base1) {

        FeedSquareHotGrideAdapter adapter = new FeedSquareHotGrideAdapter(image_base1, image_base, mContext);
        images.setAdapter(adapter);
    }

    public void setupAttention(ImageView upAttention) {
        upAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2016/9/6  加到数据库里面 数据库里面存储的什么数据
            }
        });
    }




    class ViewHolder {
        @BindView(R.id.feed_square_hot_cir)
        CircleImageView avatar_url;
        @BindView(R.id.feed_square_hot_tv)
        TextView nickname;
        @BindView(R.id.feed_square_hot_add)
        ImageView add;
        @BindView(R.id.feed_square_hot_des)
        TextView text;
        @BindView(R.id.feed_square_hot_grid)
        CustomGridView images;
        @BindView(R.id.feed_square_hot_time)
        TextView updated_at;
        @BindView(R.id.feed_square_hot_likes)
        TextView likes_count;
        @BindView(R.id.feed_square_hot_comment)
        TextView comment;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
