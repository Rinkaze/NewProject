package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.presenter.BanmiPresenter;
import com.everywhere.trip.ui.main.activity.BanmiInfoActivity;
import com.everywhere.trip.ui.main.adapter.RecBanmiAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.util.ToastUtil;
import com.everywhere.trip.view.main.BanmiView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/5/6.
 */

public class BanmiFragment extends BaseFragment<BanmiView, BanmiPresenter> implements BanmiView{
    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;

    private int page = 1;
    private ArrayList<BanmiBean.ResultEntity.BanmiEntity> list;
    private RecBanmiAdapter adapter;

    @Override
    protected BanmiPresenter initPresenter() {
        return new BanmiPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_banmi;
    }

    @Override
    protected void initView() {
        showLoading();
        list = new ArrayList<>();
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecBanmiAdapter(getContext());
        recView.setAdapter(adapter);
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
        adapter.setOnFollowCliclListener(new RecBanmiAdapter.OnFollowCliclListener() {
            @Override
            public void onFollow(int id) {
                mPresenter.addLike((String) SpUtil.getParam(Constants.TOKEN,""),id);
            }

            @Override
            public void cancelFollow(int id) {
                mPresenter.disLike((String) SpUtil.getParam(Constants.TOKEN,""),id);
            }
        });
        adapter.setOnItemClickListener(new RecBanmiAdapter.OnItemClickListener() {
            @Override
            public void onClick(BanmiBean.ResultEntity.BanmiEntity entity) {
                Intent intent = new Intent(getContext(), BanmiInfoActivity.class);
                intent.putExtra(Constants.DATA,entity.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getBanmiData(page, (String) SpUtil.getParam(Constants.TOKEN,""));
    }

    @Override
    public void onSuccess(BanmiBean.ResultEntity entity) {
        hideLoading();
        if (page == 1){
            list.clear();
        }
        list.addAll(entity.getBanmi());
        adapter.setList(list);
        srl.finishRefresh();
        srl.finishLoadMore();
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void toastShort(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
