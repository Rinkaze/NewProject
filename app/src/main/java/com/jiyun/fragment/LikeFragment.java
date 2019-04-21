package com.jiyun.fragment;

import com.jiyun.base.BaseFragment;
import com.jiyun.day03.R;
import com.jiyun.presenter.EmptyPresenter;
import com.jiyun.presenter.GankPresenter;
import com.jiyun.view.EmptyView;
import com.jiyun.view.GankView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class LikeFragment extends BaseFragment<EmptyView,EmptyPresenter> implements EmptyView{
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.like_layout;
    }
}
