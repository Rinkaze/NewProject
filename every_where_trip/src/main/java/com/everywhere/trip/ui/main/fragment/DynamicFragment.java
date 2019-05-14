package com.everywhere.trip.ui.main.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.ui.main.adapter.RecDynamicAdapter;
import com.everywhere.trip.view.main.EmptyView;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/5/12.
 */

public class DynamicFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.rl_parent)
    RelativeLayout rlParent;
    private RecDynamicAdapter adapter;
    private PopupWindow popupWindow;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        BanmiInfo.ResultEntity resultEntity = (BanmiInfo.ResultEntity) getArguments().getSerializable(Constants.DATA);
        adapter = new RecDynamicAdapter(getContext(), resultEntity.getActivities());
        recView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        adapter.setOnImageClickListener(new RecDynamicAdapter.OnImageClickListener() {
            @Override
            public void onClick(String imgUrl) {
                popup(imgUrl);
            }
        });
    }

    private void popup(String imgUrl) {
        View view = View.inflate(getContext(), R.layout.layout_zoomimg, null);
        PhotoView photo = view.findViewById(R.id.photo);
        Glide.with(this).load(imgUrl).into(photo);
        photo.enable();
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(rlParent, Gravity.CENTER,0,0);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
