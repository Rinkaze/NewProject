package com.everywhere.trip.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Button;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.presenter.LoginPresenter;
import com.everywhere.trip.ui.main.fragment.LoginOrBindFragment;
import com.everywhere.trip.view.main.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        mPresenter.getVerifyCode();
    }

    @Override
    protected void initView() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl_container,new LoginOrBindFragment()).commit();
    }
}
