package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.VerifyCodeBean;
import com.everywhere.trip.model.LoginModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.EmptyView;
import com.everywhere.trip.view.main.VerifyView;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class VerifyPresenter extends BasePresenter<VerifyView> {

    private LoginModel model;

    @Override
    protected void initModel() {
        model = new LoginModel();
        mModels.add(model);
    }

    public void getVerifyCode(){
        model.getVerifyCode(new ResultCallBack<VerifyCodeBean>() {
            @Override
            public void onSuccess(VerifyCodeBean bean) {
                if (bean != null && bean.getCode() == 200){
                    mMvpView.onSuccess(bean.getData());
                }else {
                    mMvpView.onFail(bean.getRet());
                }
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
