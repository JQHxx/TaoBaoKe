package com.bestsoft.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bestsoft.R;
import com.bestsoft.base.BaseActivity;
import com.bestsoft.ui.adapter.BasePagerAdapter;
import com.bestsoft.ui.fragment.OrderListFragment;
import com.bestsoft.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 团队数据
 */
public class TeamDataActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.btn_myteam)
    Button btnMyteam;
    @BindView(R.id.btn_invite_fans)
    Button btnInviteFans;

    @Override
    protected int getLayout() {
        return R.layout.activity_team_data;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        List<String> mTitleList = new ArrayList<>();
        List<Fragment> mFragments = new ArrayList<>();
        mTitleList.add("干货定制");
        mTitleList.add("Android");
        mTitleList.add("生活福利");
        mTitleList.add("休息视频");
        mFragments.add(new OrderListFragment());
        mFragments.add(new OrderListFragment());
        mFragments.add(new OrderListFragment());
        mFragments.add(new OrderListFragment());
        initTabViewPager(mFragments, mTitleList);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                .init();
    }

    private void initTabViewPager(List<Fragment> mFragments, List<String> mTitleList) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BasePagerAdapter myAdapter = new BasePagerAdapter(supportFragmentManager, mFragments, mTitleList);
        viewpager.setAdapter(myAdapter);
        // 左右预加载页面的个数
        viewpager.setOffscreenPageLimit(4);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setupWithViewPager(viewpager);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @OnClick({R.id.img_back, R.id.btn_myteam, R.id.btn_invite_fans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                break;
            case R.id.btn_myteam:
                IntentUtils.get().goActivity(mContext, MyTeamActivity.class);
                break;
            case R.id.btn_invite_fans:
                break;
        }
    }
}