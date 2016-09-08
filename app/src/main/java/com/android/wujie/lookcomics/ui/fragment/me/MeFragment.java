package com.android.wujie.lookcomics.ui.fragment.me;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.wujie.lookcomics.R;
import com.android.wujie.lookcomics.ui.activity.me.MeLoginActivity;
import com.android.wujie.lookcomics.ui.activity.me.MeSetupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {


    @BindView(R.id.me_mymessage_tv)
    TextView meMymessageTv;
    @BindView(R.id.me_myattention_tv1)
    TextView meMyattentionTv1;
    @BindView(R.id.me_collection_tv)
    TextView meCollectionTv;
    @BindView(R.id.me_down_tv)
    TextView meDownTv;
    @BindView(R.id.me_down_tv2)
    TextView meDownTv2;
    @BindView(R.id.me_setup_tv)
    TextView mySetup;
    private Context mContext;

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment, container, false);


        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.me_mymessage_tv, R.id.me_myattention_tv1, R.id.me_collection_tv, R.id.me_down_tv, R.id.me_down_tv2, R.id.me_setup_tv})
    public void onClick(View view) {
        Intent intent=new Intent();
        switch (view.getId()) {
            case R.id.me_mymessage_tv:
                intent.setClass(mContext, MeLoginActivity.class);
                break;
            case R.id.me_myattention_tv1:
                intent.setClass(mContext, MeLoginActivity.class);
                break;
            case R.id.me_collection_tv:
                intent.setClass(mContext, MeLoginActivity.class);
                break;
            case R.id.me_down_tv:
                break;
            case R.id.me_down_tv2:
                break;
            case R.id.me_setup_tv:
                intent.setClass(mContext, MeSetupActivity.class);
                break;
        }
        startActivity(intent);
    }
}
