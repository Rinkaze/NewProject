package com.jiyun.fragment;

import com.jiyun.base.BaseFragment;
import com.jiyun.day03.R;
import com.jiyun.presenter.EmptyPresenter;
import com.jiyun.view.EmptyView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class AboutFragment extends BaseFragment<EmptyView,EmptyPresenter> implements EmptyView{
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.about_layout;
    }
}
