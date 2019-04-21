package com.jiyun.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.adapter.VpZhihuAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.day03.R;
import com.jiyun.presenter.ZhihuPresenter;
import com.jiyun.view.ZhihuView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class ZhihuFragment extends BaseFragment<ZhihuView, ZhihuPresenter> implements ZhihuView {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<Integer> titles;
    private ArrayList<Fragment> fragments;
    private VpZhihuAdapter zhihuAdapter;

    @Override
    protected ZhihuPresenter initPresenter() {
        return new ZhihuPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zhihu_layout;
    }

    @Override
    protected void initView() {
        tab.setupWithViewPager(vp);
        initTitles();
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new DailyNewsFragment());
        fragments.add(new SelectionsFragment());
        fragments.add(new HotFragment());
        zhihuAdapter = new VpZhihuAdapter(getContext(), getChildFragmentManager(), fragments, titles);
        vp.setAdapter(zhihuAdapter);
    }

    private void initTitles() {
        titles = new ArrayList<>();
        titles.add(R.string.dailyNews);
        titles.add(R.string.selections);
        titles.add(R.string.hot);
    }
}
