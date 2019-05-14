package com.everywhere.trip.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.presenter.LikePresenter;
import com.everywhere.trip.ui.main.activity.MainInfoActivity;
import com.everywhere.trip.ui.my.adapter.RecLikeAdapter;
import com.everywhere.trip.util.ToastUtil;
import com.everywhere.trip.view.my.LikeView;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LikeActivity extends BaseActivity<LikeView, LikePresenter> implements LikeView {

    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    private RecLikeAdapter adapter;
    private ArrayList<LikeBean.ResultEntity.CollectedRoutesEntity> list;
    private int page = 1;

    @Override
    protected LikePresenter initPresenter() {
        return new LikePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_like;
    }

    @Override
    public void onSuccess(LikeBean.ResultEntity resultEntity) {
        if (page == 1){
            list.clear();
        }
        list.addAll(resultEntity.getCollectedRoutes());
        adapter.setList(list);
        srl.finishRefresh();
        srl.finishLoadMore();
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        list = new ArrayList<>();
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecLikeAdapter(this);
        recView.setAdapter(adapter);
        toolbar.setNavigationIcon(R.mipmap.back_white);
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(new RecLikeAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(LikeActivity.this, MainInfoActivity.class);
                intent.putExtra(Constants.DATA,list.get(position).getId());
                startActivity(intent);
            }
        });
        srl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                initData();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getLikeData(page);
    }
}
