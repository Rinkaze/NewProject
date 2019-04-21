package com.jiyun.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.jiyun.adapter.RecWechatAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.WechatBean;
import com.jiyun.day03.R;
import com.jiyun.presenter.WeChatPresenter;
import com.jiyun.view.WeChatView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class WeChatFragment extends BaseFragment<WeChatView, WeChatPresenter> implements WeChatView {

    @BindView(R.id.we_rec)
    RecyclerView recView;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private int page = 1;
    private RecWechatAdapter wechatAdapter;
    private ArrayList<WechatBean.NewslistEntity> list;
    private String word;

    @Override
    protected WeChatPresenter initPresenter() {
        return new WeChatPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.wechat_layout;
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
        wechatAdapter = new RecWechatAdapter(getContext());
        recView.setAdapter(wechatAdapter);
        list = new ArrayList<>();
    }

    @Override
    protected void initListener() {
        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                if (!TextUtils.isEmpty(word)) {
                    mPresenter.getSearchWechatData(page, word);
                } else {
                    mPresenter.getWechatData(page);
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                if (!TextUtils.isEmpty(word)) {
                    mPresenter.getSearchWechatData(page, word);
                } else {
                    mPresenter.getWechatData(page);
                }
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getWechatData(page);
    }

    public void getData(String word) {
        this.word = word;
        page = 1;
        mPresenter.getSearchWechatData(page, word);
    }

    @Override
    public void updateUi(WechatBean wechatBean) {
        if (page == 1) {
            list.clear();
            list.addAll(wechatBean.getNewslist());
        } else {
            list.addAll(wechatBean.getNewslist());
        }
        wechatAdapter.setList(list);
        smart.finishRefresh();
        smart.finishLoadMore();
    }
}
