package com.jiyun.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.adapter.RecSelectionsAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.SelectionsBean;
import com.jiyun.day03.R;
import com.jiyun.presenter.SelectionsPresenter;
import com.jiyun.view.GoldView;
import com.jiyun.view.SelectionsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class SelectionsFragment extends BaseFragment<SelectionsView, SelectionsPresenter> implements SelectionsView {
    @BindView(R.id.recView)
    RecyclerView recView;
    private RecSelectionsAdapter selectionsAdapter;

    @Override
    protected SelectionsPresenter initPresenter() {
        return new SelectionsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.selections_layout;
    }

    @Override
    protected void initData() {
        mPresenter.getSelectionsData();
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new GridLayoutManager(getContext(),2));
        selectionsAdapter = new RecSelectionsAdapter(getContext());
        recView.setAdapter(selectionsAdapter);
    }

    @Override
    public void updateUi(SelectionsBean selectionsBean) {
        selectionsAdapter.setList(selectionsBean.getData());
    }
}
