package com.everywhere.trip.ui.my.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.presenter.FollowPresenter;
import com.everywhere.trip.ui.main.activity.BanmiInfoActivity;
import com.everywhere.trip.ui.main.adapter.RecBanmiAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.my.FollowView;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class FollowActivity extends BaseActivity<FollowView, FollowPresenter> implements FollowView {


    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private RecBanmiAdapter adapter;
    private int page = 1;
    private ArrayList<BanmiBean.ResultEntity.BanmiEntity> list;

    @Override
    protected FollowPresenter initPresenter() {
        return new FollowPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_follow;
    }

    @Override
    public void onSuccess(BanmiBean.ResultEntity entity) {
        if (page == 1){
            list.clear();
        }
        list.addAll(entity.getBanmi());
        adapter.setList(list);
        srl.finishLoadMore();
        srl.finishRefresh();
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        list = new ArrayList<>();
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecBanmiAdapter(this);
        recView.setAdapter(adapter);
        toolBar.setNavigationIcon(R.mipmap.back_white);
    }

    @Override
    protected void initListener() {
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
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter.setOnItemClickListener(new RecBanmiAdapter.OnItemClickListener() {
            @Override
            public void onClick(BanmiBean.ResultEntity.BanmiEntity entity) {
                Intent intent = new Intent(FollowActivity.this, BanmiInfoActivity.class);
                intent.putExtra(Constants.DATA,entity.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getLikeData((String) SpUtil.getParam(Constants.TOKEN,""),page);
    }
}
