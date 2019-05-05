package com.everywhere.trip.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.presenter.VerifyPresenter;
import com.everywhere.trip.view.main.VerifyView;
import com.everywhere.trip.widget.IdentifyingCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class VerifyFragment extends BaseFragment<VerifyView, VerifyPresenter> implements VerifyView {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_send_again)
    TextView tvSendAgain;
    @BindView(R.id.icv)
    IdentifyingCodeView icv;
    @BindView(R.id.tv_wait)
    TextView tvWait;

    @Override
    protected VerifyPresenter initPresenter() {
        return new VerifyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_verify;
    }

    @Override
    protected void initListener() {
        icv.setInputCompleteListener(new IdentifyingCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                if (icv.getTextContent().length() == icv.getTextCount()){
                    tvWait.setVisibility(View.VISIBLE);
                    icv.setBackgroundEnter(true);
                    icv.setEditable(false);
                }
            }

            @Override
            public void deleteContent() {

            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        getActivity().onBackPressed();
    }
}
