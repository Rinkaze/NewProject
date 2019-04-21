package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.LoginBean;
import com.jiyun.model.LoginModel;
import com.jiyun.net.Callback;
import com.jiyun.view.LoginView;

/**
 * Created by 灵风 on 2019/4/2.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginModel mMainModel;
    private static final String TAG = "LoginPresenter";

    public void login(){
        String uName = mMvpView.getUserName();
        String psw = mMvpView.getPsw();
        mMainModel.login(uName, psw, new Callback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if (loginBean != null){
                    Log.e(TAG, "onSuccess: "+loginBean.toString());
                    if (loginBean.getCode() == 200){
                        if (mMvpView != null){
                            mMvpView.showToast("登陆成功");
                        }
                    }else {
                        if (mMvpView!=null){
                            mMvpView.showToast("登陆失败");
                        }
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.showToast("登陆失败");
                }
                Log.e(TAG, "onFail: "+msg );
            }
        });
    }

    @Override
    public void initModel() {
        mMainModel = new LoginModel();
        models.add(mMainModel);
    }
}
