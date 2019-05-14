package com.everywhere.trip.ui.main.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.ui.main.fragment.BanmiFragment;
import com.everywhere.trip.ui.main.fragment.MainFragment;
import com.everywhere.trip.ui.my.activity.FollowActivity;
import com.everywhere.trip.ui.my.activity.InformationActivity;
import com.everywhere.trip.ui.my.activity.LikeActivity;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.EmptyView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {

    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.iv_message)
    ImageView ivMessage;

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    final int TYPE_MAIN = 0;
    final int TYPE_BANMI = 1;
    private int lastPosition = 0;
    private TextView tvMain;
    private TextView tvBanmi;
    private ImageView ivHeaderLeft;
    /**
     * 林
     */
    private TextView tvNameLeft;
    /**
     * 暂无
     */
    private TextView tvInfoLeft;
    /**
     * 编辑
     */
    private TextView tvEditLeft;
    private ImageView ivEditLeft;
    private RelativeLayout rlTitleLeft;
    /**
     * 99
     */
    private TextView tvMoneyLeft;
    /**
     * 赢取奖金
     */
    private TextView tvBonusLeft;
    private RelativeLayout rlMoneybagLeft;
    private ImageView ivKaquanLeft;
    private RelativeLayout rlKaquanLeft;
    private ImageView ivTripLeft;
    private RelativeLayout rlTripLeft;
    private ImageView ivLikeLeft;
    private RelativeLayout rlLikeLeft;
    private ImageView ivFollowLeft;
    private RelativeLayout rlFollowLeft;
    /**
     * 联系客服
     */
    private TextView tvServiceLeft;
    /**
     * 意见反馈
     */
    private TextView tvIdeaLeft;
    /**
     * 版本检测
     */
    private TextView tvVersionLeft;
    private CardView cvLeft;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        View headerView = mNv.getHeaderView(0);
        ivHeaderLeft = (ImageView) headerView.findViewById(R.id.iv_header_left);
        tvNameLeft = (TextView) headerView.findViewById(R.id.tv_name_left);
        tvInfoLeft = (TextView) headerView.findViewById(R.id.tv_info_left);
        tvEditLeft = (TextView) headerView.findViewById(R.id.tv_edit_left);
        ivEditLeft = (ImageView) headerView.findViewById(R.id.iv_edit_left);
        rlTitleLeft = (RelativeLayout) headerView.findViewById(R.id.rl_title_left);
        tvMoneyLeft = (TextView) headerView.findViewById(R.id.tv_money_left);
        tvBonusLeft = (TextView) headerView.findViewById(R.id.tv_bonus_left);
        rlMoneybagLeft = (RelativeLayout) headerView.findViewById(R.id.rl_moneybag_left);
        ivKaquanLeft = (ImageView) headerView.findViewById(R.id.iv_kaquan_left);
        rlKaquanLeft = (RelativeLayout) headerView.findViewById(R.id.rl_kaquan_left);
        ivTripLeft = (ImageView) headerView.findViewById(R.id.iv_trip_left);
        rlTripLeft = (RelativeLayout) headerView.findViewById(R.id.rl_trip_left);
        ivLikeLeft = (ImageView) headerView.findViewById(R.id.iv_like_left);
        rlLikeLeft = (RelativeLayout) headerView.findViewById(R.id.rl_like_left);
        ivFollowLeft = (ImageView) headerView.findViewById(R.id.iv_follow_left);
        rlFollowLeft = (RelativeLayout) headerView.findViewById(R.id.rl_follow_left);
        tvServiceLeft = (TextView) headerView.findViewById(R.id.tv_service_left);
        tvIdeaLeft = (TextView) headerView.findViewById(R.id.tv_idea_left);
        tvVersionLeft = (TextView) headerView.findViewById(R.id.tv_version_left);
        cvLeft = (CardView) headerView.findViewById(R.id.cv_left);

        String photo = (String) SpUtil.getParam(Constants.PHOTO, "");
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, photo, ivHeader, this);
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, photo, ivHeaderLeft, this);
        tvNameLeft.setText((String) SpUtil.getParam(Constants.USERNAME, "user"));
        tvInfoLeft.setText((String) SpUtil.getParam(Constants.DESC, "暂无"));
        tab.addTab(tab.newTab().setCustomView(R.layout.item_tab_main));
        tab.addTab(tab.newTab().setCustomView(R.layout.item_tab_banmi));
        tvMain = (TextView) tab.getTabAt(0).getCustomView().findViewById(R.id.tv_main);
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, (String) SpUtil.getParam(Constants.TOKEN, ""));
        mainFragment.setArguments(bundle);
        fragments.add(mainFragment);
        fragments.add(new BanmiFragment());
        manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.add(R.id.fragment_container, fragments.get(0));
        tran.commit();
    }

    @Override
    protected void initListener() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tvMain.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        if (tvBanmi != null) {
                            tvBanmi.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        switchFragment(TYPE_MAIN);
                        break;
                    case 1:
                        if (tvBanmi == null) {
                            tvBanmi = (TextView) tab.getCustomView().findViewById(R.id.tv_banmi);
                        }
                        if (tvMain != null) {
                            tvMain.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        tvBanmi.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        switchFragment(TYPE_BANMI);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ivHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDl.openDrawer(Gravity.LEFT);
            }
        });

        rlTitleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InformationActivity.class));
            }
        });

        rlFollowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FollowActivity.class));
            }
        });

        rlLikeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LikeActivity.class));
            }
        });
    }

    private static final String TAG = "MainActivity";

    private void switchFragment(int type) {
        FragmentTransaction tran = manager.beginTransaction();
        Fragment fragment = fragments.get(type);
        if (!fragment.isAdded()) {
            tran.add(R.id.fragment_container, fragment);
        }
        tran.hide(fragments.get(lastPosition));
        tran.show(fragment);
        tran.commit();
        lastPosition = type;
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = (String) SpUtil.getParam(Constants.USERNAME, "no");
        String signature = (String) SpUtil.getParam(Constants.DESC, "未设置");
        String photo = (String) SpUtil.getParam(Constants.PHOTO, "");
        tvNameLeft.setText(name);
        tvInfoLeft.setText(signature);
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, photo, ivHeaderLeft, this);
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, photo, ivHeader, this);
    }

}
