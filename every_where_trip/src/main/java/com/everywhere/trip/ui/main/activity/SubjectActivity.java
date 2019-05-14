package com.everywhere.trip.ui.main.activity;

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
import com.everywhere.trip.bean.BundlesBean;
import com.everywhere.trip.presenter.SubjectPresenter;
import com.everywhere.trip.ui.main.adapter.RecSubjectAdapter;
import com.everywhere.trip.view.main.SubjectView;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class SubjectActivity extends BaseActivity<SubjectView, SubjectPresenter> implements SubjectView {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.recView)
    RecyclerView mRecView;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    private RecSubjectAdapter adapter;
    private ArrayList<BundlesBean.ResultEntity.BundlesEntity> list;

    @Override
    public void onSuccess(BundlesBean.ResultEntity entity) {
        list= (ArrayList<BundlesBean.ResultEntity.BundlesEntity>) entity.getBundles();
        adapter.setList(list);
        mSrl.finishRefresh();
        mSrl.finishLoadMore();
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected SubjectPresenter initPresenter() {
        return new SubjectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_subject;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        mToolBar.setTitle("");
        list = new ArrayList<>();
        mToolBar.setNavigationIcon(R.mipmap.back_white);
        adapter = new RecSubjectAdapter(this);
        mRecView.setLayoutManager(new LinearLayoutManager(this));
        mRecView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.getBundles();
    }

    @Override
    protected void initListener() {
        adapter.setOnBundleClickListener(new RecSubjectAdapter.OnBundleClickListener() {
            @Override
            public void onClick(String url,String title) {
                Intent intent = new Intent(SubjectActivity.this, WebViewActivity.class);
                intent.putExtra(Constants.DATA,url+"?os=android");
                intent.putExtra(Constants.TITLE,title);
                startActivity(intent);
                finish();
            }
        });

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });
    }
}
