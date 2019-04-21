package com.jiyun.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.adapter.VpGoldAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.base.Constants;
import com.jiyun.bean.GoldTitleBean;
import com.jiyun.day03.R;
import com.jiyun.day03.ShowActivity;
import com.jiyun.presenter.GoldPresenter;
import com.jiyun.view.GankView;
import com.jiyun.view.GoldView;

import java.util.ArrayList;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class GoldFragment extends BaseFragment<GankView, GoldPresenter> implements GoldView {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<GoldTitleBean> mTitles;
    private ArrayList<Fragment> fragments;
    private VpGoldAdapter adapter;

    @Override
    protected GoldPresenter initPresenter() {
        return new GoldPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gold_layout;
    }

    @Override
    protected void initView() {
        initTitles();
        setFragments();
        tabLayout.setupWithViewPager(vp);
    }

    private void setFragments() {
        initFragments();
        adapter = new VpGoldAdapter(getChildFragmentManager(), mTitles, fragments);
        vp.setAdapter(adapter);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            GoldTitleBean titleBean = mTitles.get(i);
            if (titleBean.isChecked){
                fragments.add(GoldDetailFragment.newInstance(titleBean.title));
            }
        }
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(new GoldTitleBean("Android",true));
        mTitles.add(new GoldTitleBean("iOS",true));
        mTitles.add(new GoldTitleBean("设计",true));
        mTitles.add(new GoldTitleBean("产品",true));
        mTitles.add(new GoldTitleBean("工具资源",true));
        mTitles.add(new GoldTitleBean("阅读",true));
        mTitles.add(new GoldTitleBean("前端",true));
        mTitles.add(new GoldTitleBean("后端",true));
    }

    @Override
    protected void initListener() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShowActivity.class);
                intent.putExtra(Constants.DATA,mTitles);
                startActivityForResult(intent,17);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 17 && resultCode == RESULT_OK){
            if (data != null){
                mTitles = (ArrayList<GoldTitleBean>) data.getSerializableExtra(Constants.DATA);
                setFragments();
            }
        }
    }
}
