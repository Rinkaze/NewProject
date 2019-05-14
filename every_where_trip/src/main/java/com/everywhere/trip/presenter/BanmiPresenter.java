package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.model.BanmiModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.BanmiView;

/**
 * Created by 灵风 on 2019/5/6.
 */

public class BanmiPresenter extends BasePresenter<BanmiView> {

    private BanmiModel model;

    @Override
    protected void initModel() {
        model = new BanmiModel();
        mModels.add(model);
    }

    public void getBanmiData(int page,String token){
        model.getBanmiData(page, token, new ResultCallBack<BanmiBean>() {
            @Override
            public void onSuccess(BanmiBean bean) {
                mMvpView.onSuccess(bean.getResult());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }

    public void addLike(String token,int id){
        model.addLike(token, id, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.toastShort(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.toastShort(msg);
            }
        });
    }

    public void disLike(String token,int id){
        model.disLike(token, id, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.toastShort(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.toastShort(msg);
            }
        });
    }
}
