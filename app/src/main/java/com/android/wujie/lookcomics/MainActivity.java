package com.android.wujie.lookcomics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.wujie.lookcomics.ui.fragment.discover.DisCoverFragment;
import com.android.wujie.lookcomics.ui.fragment.feed.FeedFragment;
import com.android.wujie.lookcomics.ui.fragment.home.HomeFragment;
import com.android.wujie.lookcomics.ui.fragment.me.MeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.BehaviorSubject;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{


    private HomeFragment mHomeFragment;
    private DisCoverFragment mDisCoverFragment;
    private FeedFragment mFeedFragment;
    private MeFragment mMeFragment;
    private Fragment currFragment;
    private FragmentManager mFragmentManager;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.main_rgroup);
        loadFragment();
        mFragmentManager = getSupportFragmentManager();
        mRadioGroup.setOnCheckedChangeListener(this);
        showFragment(mDisCoverFragment);

    }



    /**
     * 加载viewpage的数据
     */
    private void loadFragment() {
        mHomeFragment = HomeFragment.newInstance();
        mDisCoverFragment = DisCoverFragment.newInstance();
        mFeedFragment = FeedFragment.newInstance();
        mMeFragment = MeFragment.newInstance();
    }

    /**
     * @param fragment
     * 显示/隐藏fragment
     */
public void showFragment(Fragment fragment){
    FragmentTransaction transaction = mFragmentManager.beginTransaction();
    if (currFragment!=null&& currFragment.isAdded()){
        transaction.hide(currFragment);
    }
    if (!fragment.isAdded()){
        transaction.add(R.id.main_flayout,fragment);
    }else {
        transaction.show(fragment);
    }
    transaction.commit();
    currFragment=fragment;


}

    /**
     * @param group
     * @param checkedId
     * radiogroup 的监听设置
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_rbtn_home:
                showFragment(mHomeFragment);
                break;
            case R.id.main_rbtn_discover:
                showFragment(mDisCoverFragment);
                break;
            case R.id.main_rbtn_feed:
                showFragment(mFeedFragment);
                break;
            case R.id.main_rbtn_me:
                showFragment(mMeFragment);
                break;

        }
    }
}
