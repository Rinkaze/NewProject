package com.jiyun.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jiyun.adapter.RecHotAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.HotBean;
import com.jiyun.day03.R;
import com.jiyun.presenter.HotPresenter;
import com.jiyun.view.HotView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class HotFragment extends BaseFragment<HotView, HotPresenter> implements HotView {
    @BindView(R.id.recView)
    RecyclerView recView;
    private RecHotAdapter hotAdapter;

    @Override
    protected HotPresenter initPresenter() {
        return new HotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.selections_layout;
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
        hotAdapter = new RecHotAdapter(getContext());
        recView.setAdapter(hotAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getHotData();
    }

    @Override
    public void updateUi(HotBean hotBean) {
        List<HotBean.RecentEntity> recent = hotBean.getRecent();
        hotAdapter.setList(hotBean.getRecent());
    }

}
