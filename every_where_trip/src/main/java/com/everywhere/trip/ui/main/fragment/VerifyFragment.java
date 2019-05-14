package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.presenter.VerifyPresenter;
import com.everywhere.trip.ui.main.activity.LoginActivity;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.util.ToastUtil;
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
    private int time;

    private String verify = "";

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
                if (icv.getTextContent().length() == icv.getTextCount()) {
                    tvWait.setText(getResources().getString(R.string.wait_please));
                    if (icv.getTextContent().equals(verify)) {
                        icv.setBackgroundEnter(true);
                        icv.setEditable(false);
                        ToastUtil.showShort(getResources().getString(R.string.login_success));
                        startActivity(new Intent(getContext(), MainActivity.class));
                    } else {
                        ToastUtil.showShort(getResources().getString(R.string.verify_error));
                    }
                }
            }

            @Override
            public void deleteContent() {

            }
        });
    }

    @OnClick({R.id.iv_back,R.id.tv_send_again})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                getActivity().onBackPressed();
                break;
            case R.id.tv_send_again:
                if (tvSendAgain != null && tvSendAgain.getText().toString().equals(getResources().getString(R.string.send_again))){
                    LoginOrBindFragment fragment = (LoginOrBindFragment) getActivity().getSupportFragmentManager().findFragmentByTag(LoginActivity.TAG);
                    fragment.sendVerify();
                }
                break;
        }
    }

    @Override
    public void onSuccess(String data) {
        verify = data;
        setData(getResources().getString(R.string.verify_code) + data);
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }

    public void setTimeAndColor(String time,int color){
        if (tvSendAgain != null){
            tvSendAgain.setText(time);
            tvSendAgain.setTextColor(color);
        }
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        if (arguments != null){
            verify = arguments.getString("verify");
            setData(verify);
        }
    }

    public void setData(String verify){
        if (!TextUtils.isEmpty(verify) && tvWait != null){
            this.verify = verify;
            tvWait.setText(verify);
        }
    }

}
