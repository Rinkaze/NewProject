package com.everywhere.trip.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.presenter.ReviewsPresenter;
import com.everywhere.trip.ui.main.adapter.RecReviewsAdapter;
import com.everywhere.trip.view.main.ReviewsView;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 灵风 on 2019/5/13.
 */

public class ReviewsActivity extends BaseActivity<ReviewsView, ReviewsPresenter> implements ReviewsView {
    @BindView(R.id.recView)
    RecyclerView mRecView;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    private RecReviewsAdapter adapter;
    private int page = 1;
    private ArrayList<MainDataInfo.ResultEntity.ReviewsEntity> list;

    @Override
    public void onSuccess(MainDataInfo.ResultEntity resultEntity) {
        list.addAll(resultEntity.getReviews());
        adapter.setList(list);
        mSrl.finishLoadMore();
        mSrl.finishRefresh();
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected ReviewsPresenter initPresenter() {
        return new ReviewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reviews;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        list = new ArrayList<>();
        mRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecReviewsAdapter(this);
        mRecView.setAdapter(adapter);
        mToolBar.setNavigationIcon(R.mipmap.back_white);
        mToolBar.setTitle("");
    }

    @Override
    protected void initData() {
        mPresenter.getMainData(getIntent().getIntExtra(Constants.DATA, 0), page);
    }

    @Override
    protected void initListener() {
        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (page == 1) {
                    list.clear();
                }
                initData();
            }
        });
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
