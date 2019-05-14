package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.presenter.LinePresenter;
import com.everywhere.trip.ui.main.activity.MainInfoActivity;
import com.everywhere.trip.ui.main.adapter.RecMainAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/5/12.
 */

public class LineFragment extends BaseFragment<MainView, LinePresenter> implements MainView {
    @BindView(R.id.recView)
    RecyclerView recView;
    private RecMainAdapter adapter;

    @Override
    public void onSuccess(final MainDataBean.ResultEntity resultEntity) {
        adapter.setRoutes(resultEntity.getRoutes());
        adapter.setOnItemClickListener(new RecMainAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), MainInfoActivity.class);
                intent.putExtra(Constants.DATA,resultEntity.getRoutes().get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected LinePresenter initPresenter() {
        return new LinePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_line;
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        adapter = new RecMainAdapter(getContext());
        recView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.getLineData(getArguments().getInt("id"),1, (String) SpUtil.getParam(Constants.TOKEN,""));
    }
}
