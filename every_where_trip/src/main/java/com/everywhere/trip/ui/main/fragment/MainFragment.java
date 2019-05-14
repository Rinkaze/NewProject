package com.everywhere.trip.ui.main.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.presenter.MainPresenter;
import com.everywhere.trip.ui.main.activity.MainInfoActivity;
import com.everywhere.trip.ui.main.activity.WebViewActivity;
import com.everywhere.trip.ui.main.adapter.RecMainAdapter;
import com.everywhere.trip.util.Logger;
import com.everywhere.trip.view.main.MainView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/5/5.
 */

public class MainFragment extends BaseFragment<MainView, MainPresenter> implements MainView {
    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private ArrayList<MainDataBean.ResultEntity.BannersEntity> banners;
    private ArrayList<MainDataBean.ResultEntity.RoutesEntity> routes;
    private RecMainAdapter adapter;
    private int page = 1;

    @Override
    public void onSuccess(MainDataBean.ResultEntity resultEntity) {
        hideLoading();
        if (page == 1){
            banners.clear();
            routes.clear();
        }
        banners.addAll(resultEntity.getBanners());
        routes.addAll(resultEntity.getRoutes());
        adapter.setBanners(banners);
        adapter.setRoutes(routes);
        srl.finishLoadMore();
        srl.finishRefresh();
        adapter.setOnItemClickListener(new RecMainAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                MainDataBean.ResultEntity.RoutesEntity entity = routes.get(position);
                Intent intent = new Intent(getContext(), MainInfoActivity.class);
                intent.putExtra(Constants.DATA,entity.getId());
                startActivity(intent);
            }
        });
        adapter.setOnBundleClickListener(new RecMainAdapter.OnBundleClickListener() {
            @Override
            public void onClick(String url,String title) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra(Constants.DATA,url+"?os=android");
                intent.putExtra(Constants.TITLE,title);
                startActivity(intent);
            }
        });
    }

    private static final String TAG = "MainFragment";
    @Override
    public void onFail(String msg) {
        Logger.logD(TAG,msg);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
        banners = new ArrayList<>();
        routes = new ArrayList<>();
        adapter = new RecMainAdapter(getContext());
        recView.setAdapter(adapter);
        showLoading();
    }

    @Override
    protected void initData() {
        mPresenter.getMainData(page,getArguments().getString(Constants.DATA));

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

    }
}
