package com.everywhere.trip.ui.main.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.LoginInfo;
import com.everywhere.trip.presenter.LoginOrBindPresenter;
import com.everywhere.trip.ui.main.activity.LoginActivity;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.ui.main.activity.ProtocolActivity;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.util.ToastUtil;
import com.everywhere.trip.view.main.LoginOrBindView;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class LoginOrBindFragment extends BaseFragment<LoginOrBindView, LoginOrBindPresenter> implements LoginOrBindView{

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_hello)
    TextView mTvHello;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_coutry_code)
    TextView mTvCoutryCode;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.btn_send_verify)
    Button mBtnSendVerify;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.ll_or)
    LinearLayout mLlOr;
    @BindView(R.id.ll_oauth_login)
    LinearLayout mLlOauthLogin;
    @BindView(R.id.iv_wechat)
    ImageView mIvWechat;
    @BindView(R.id.iv_qq)
    ImageView mIvQq;
    @BindView(R.id.iv_sina)
    ImageView mIvSina;
    @BindView(R.id.tv_protocol)
    TextView mTvProtocol;

    private int time;

    private String verify = "";

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
                if (verifyFragment != null){
                    verifyFragment.setTimeAndColor(getResources().getString(R.string.send_again)+"("+time+")",getResources().getColor(R.color.c_cecece));
                }
                time--;
            }else {
                if (verifyFragment != null) {
                    verifyFragment.setTimeAndColor(getResources().getString(R.string.send_again), getResources().getColor(R.color.c_fa6a13));
                }
            }
        }
    };
    private VerifyFragment verifyFragment;

    @Override
    protected LoginOrBindPresenter initPresenter() {
        return new LoginOrBindPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_bind;
    }

    public static LoginOrBindFragment newInstance(int type){
        LoginOrBindFragment fragment = new LoginOrBindFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.TYPE,type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @OnClick({R.id.iv_back, R.id.btn_send_verify, R.id.iv_wechat, R.id.iv_qq, R.id.iv_sina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.btn_send_verify:
                if (time<=0){
                    addVerifyFragment();
                    sendVerify();
                    return;
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("verify",verify);
                    verifyFragment.setArguments(bundle);
                }
                addVerifyFragment();
                break;
            case R.id.iv_wechat:
                break;
            case R.id.iv_qq:
                mPresenter.oauthLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.iv_sina:
                mPresenter.oauthLogin(SHARE_MEDIA.SINA);
                break;
        }
    }

    public void sendVerify() {
        if (time <= 0){
            mPresenter.getVerifyCode();
            time = 10;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                if (time>0){
                    handler.postDelayed(this,1000);
                }else {
                    handler.sendEmptyMessage(1);
                }
            }
        },0);
    }

    private void addVerifyFragment() {
        if (TextUtils.isEmpty(getPhone())){
            Toast.makeText(getContext(), "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }


        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //添加到回退栈
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fl_container, verifyFragment).commit();
    }

    @Override
    protected void initListener() {
        //文本发生改变监听
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switchBtnState(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 根据输入框中是否有内容,切换发送验证码的背景
     * @param s
     */
    private void switchBtnState(CharSequence s) {
        if (TextUtils.isEmpty(s)){
            mBtnSendVerify.setBackgroundResource(R.drawable.bg_btn_ea_r15);
        }else {
            mBtnSendVerify.setBackgroundResource(R.drawable.bg_btn_fa6a13_r15);
        }

    }

    @Override
    public String getPhone() {
        return mEtPhone.getText().toString().trim();
    }

    @Override
    public Activity getAct() {
        return getActivity();
    }

    @Override
    public void toastShort(String string) {
        ToastUtil.showShort(string);
    }

    @Override
    public void go2MainActivity(LoginInfo.ResultBean result) {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra(Constants.DATA,result);
        startActivity(intent);
    }

    @Override
    public void setData(String data) {
        this.verify = data;
        if (verifyFragment != null)
            verifyFragment.setData(data);
    }

    @Override
    protected void initView() {
        setProtocol();
        Bundle bundle = getArguments();
        if (bundle.getInt(Constants.TYPE) == LoginActivity.LOGIN){
            mIvBack.setVisibility(View.INVISIBLE);
            mLlOauthLogin.setVisibility(View.VISIBLE);
            mLlOr.setVisibility(View.VISIBLE);
        }else {
            mIvBack.setVisibility(View.VISIBLE);
            mLlOr.setVisibility(View.GONE);
            mLlOauthLogin.setVisibility(View.GONE);
        }
        verifyFragment = new VerifyFragment();
    }

    private void setProtocol() {
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.agree_protocol));
        spannableString.setSpan(new UnderlineSpan(),13,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(new Intent(getContext(), ProtocolActivity.class));
            }
        },13,17,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c_fa6a13)),13,17,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        mTvProtocol.setText(spannableString);
    }

}
