package com.everywhere.trip.ui.main.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.model.BanmiInfoModel;
import com.everywhere.trip.model.BanmiModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.presenter.BanmiInfoPresenter;
import com.everywhere.trip.ui.main.fragment.DynamicFragment;
import com.everywhere.trip.ui.main.fragment.LineFragment;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.BanmiInfoView;
import com.jaeger.library.StatusBarUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BanmiInfoActivity extends BaseActivity<BanmiInfoView, BanmiInfoPresenter> implements BanmiInfoView {

    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.iv_follow)
    ImageView ivFollow;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_like_count)
    TextView tvLikeCount;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_occupation)
    TextView tvOccupation;
    @BindView(R.id.tv_intro)
    TextView tvIntro;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private BanmiInfo.ResultEntity.BanmiEntity banmi;

    @Override
    public void onSuccess(BanmiInfo banmiInfo) {
        hideLoading();
        banmi = banmiInfo.getResult().getBanmi();
        GlideUtil.loadUrlRoundImg(10, R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, banmi.getPhoto(), img, this);
        if (banmi.isIsFollowed()) {
            GlideUtil.loadResImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, R.mipmap.follow, ivFollow, this);
        }
        tvName.setText(banmi.getName());
        tvLikeCount.setText(banmi.getFollowing() + "人关注");
        tvCity.setText(banmi.getLocation());
        tvOccupation.setText(banmi.getOccupation());
        tvIntro.setText(banmi.getIntroduction());

        initFragment(banmiInfo);

        manager.beginTransaction().add(R.id.fragment_container, fragments.get(0)).commit();

        setClick();
    }

    private void setClick() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        switchFragment(0);
                        break;
                    case 1:
                        switchFragment(1);
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
        ivFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (banmi != null) {
                    BanmiModel model = new BanmiModel();
                    if (banmi.isIsFollowed()) {
                        model.disLike((String) SpUtil.getParam(Constants.TOKEN, ""), banmi.getId(), new ResultCallBack<String>() {
                            @Override
                            public void onSuccess(String bean) {
                            }

                            @Override
                            public void onFail(String msg) {
                            }
                        });
                        Toast.makeText(BanmiInfoActivity.this, "已取消关注", Toast.LENGTH_SHORT).show();
                        banmi.setIsFollowed(false);
                        ivFollow.setImageResource(R.mipmap.follow_unselected);
                    } else {
                        model.addLike((String) SpUtil.getParam(Constants.TOKEN, ""), banmi.getId(), new ResultCallBack<String>() {
                            @Override
                            public void onSuccess(String bean) {
                            }

                            @Override
                            public void onFail(String msg) {
                            }
                        });
                        Toast.makeText(BanmiInfoActivity.this, "已关注", Toast.LENGTH_SHORT).show();
                        banmi.setIsFollowed(true);
                        ivFollow.setImageResource(R.mipmap.follow);
                    }
                }
            }
        });
    }

    private void initFragment(BanmiInfo banmiInfo) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.DATA, banmiInfo.getResult());
        fragment.setArguments(bundle);
        fragments.add(fragment);

        LineFragment lineFragment = new LineFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("id", banmiInfo.getResult().getBanmi().getId());
        lineFragment.setArguments(bundle1);
        fragments.add(lineFragment);
    }

    @Override
    public void onFail(String msg) {
        hideLoading();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected BanmiInfoPresenter initPresenter() {
        return new BanmiInfoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_banmi_info;
    }

    @OnClick({R.id.iv_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_share:
                break;
        }
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        fragments = new ArrayList<>();
        toolBar.setNavigationIcon(R.mipmap.back_white);
        toolBar.setTitle("");
        tab.addTab(tab.newTab().setText("动态"));
        tab.addTab(tab.newTab().setText("线路"));
        manager = getSupportFragmentManager();
    }

    @Override
    protected void initData() {
        mPresenter.getBanmiInfo((String) SpUtil.getParam(Constants.TOKEN, ""),
                getIntent().getIntExtra(Constants.DATA, 0), 1);
        showLoading();
    }

    @Override
    protected void initListener() {
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int lastPosition = 0;

    private void switchFragment(int type) {
        Fragment fragment = fragments.get(type);
        FragmentTransaction tran = manager.beginTransaction();
        if (!fragment.isAdded()) {
            tran.add(R.id.fragment_container, fragment);
        }
        tran.hide(fragments.get(lastPosition));
        tran.show(fragment);
        tran.commit();
        lastPosition = type;
    }
}
