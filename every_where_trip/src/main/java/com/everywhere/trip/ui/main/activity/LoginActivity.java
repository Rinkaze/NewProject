package com.everywhere.trip.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.widget.Button;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.presenter.LoginPresenter;
import com.everywhere.trip.ui.main.fragment.LoginOrBindFragment;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.LoginView;
import com.umeng.socialize.UMShareAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    public static final int LOGIN = 0;
    public static final int BIND = 1;
    private static int mtype;
    public static String TAG = "loginFragment";

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_login;
    }

    public static void startAct(Context context,int type){
        mtype = type;
        context.startActivity(new Intent(context,LoginActivity.class));
    }

    @Override
    protected void initData() {
        mPresenter.getVerifyCode();
    }

    @Override
    protected void initView() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl_container, LoginOrBindFragment.newInstance(mtype),TAG).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
