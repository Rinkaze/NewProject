package com.jiyun.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.base.BaseFragment;
import com.jiyun.base.Constants;
import com.jiyun.day03.R;
import com.jiyun.presenter.EmptyPresenter;
import com.jiyun.view.EmptyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/18.
 */

public class GoldDetailFragment extends BaseFragment<EmptyView, EmptyPresenter> {

    @BindView(R.id.tv)
    TextView tv;
    private View view;

    public static Fragment newInstance(String title) {
        GoldDetailFragment fragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_detail;
    }

    @Override
    protected void initView() {
        String data = getArguments().getString(Constants.DATA);
        tv.setText(data);
    }
}
