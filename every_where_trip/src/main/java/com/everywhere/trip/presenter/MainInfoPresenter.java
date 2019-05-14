package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.model.MainInfoModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.my.MainInfoView;

/**
 * Created by 灵风 on 2019/5/8.
 */

public class MainInfoPresenter extends BasePresenter<MainInfoView> {

    private MainInfoModel model;

    @Override
    protected void initModel() {
        model = new MainInfoModel();
        mModels.add(model);
    }

    public void getDataInfo(String token, int id) {
        model.getDataInfo(token, id, new ResultCallBack<MainDataInfo>() {
            @Override
            public void onSuccess(MainDataInfo bean) {
                if (mMvpView != null){
                    mMvpView.updateUi(bean.getResult());
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onFail(msg);
                }
            }
        });
    }

    public void addLike(String token, int id) {
        model.addLike(token, id, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.onSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }

    public void disLike(String token, int id) {
        model.disLike(token, id, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                mMvpView.onSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
