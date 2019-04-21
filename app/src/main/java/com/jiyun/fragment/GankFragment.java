package com.jiyun.fragment;

import com.jiyun.base.BaseFragment;
import com.jiyun.day03.R;
import com.jiyun.presenter.GankPresenter;
import com.jiyun.presenter.ZhihuPresenter;
import com.jiyun.view.GankView;
import com.jiyun.view.ZhihuView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class GankFragment extends BaseFragment<GankView,GankPresenter> implements GankView{
    @Override
    protected GankPresenter initPresenter() {
        return new GankPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gank_layout;
    }
}
