package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.model.BanmiInfoModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.BanmiInfoView;

/**
 * Created by 灵风 on 2019/5/12.
 */

public class BanmiInfoPresenter extends BasePresenter<BanmiInfoView>{

    private BanmiInfoModel model;

    @Override
    protected void initModel() {
        model = new BanmiInfoModel();
        mModels.add(model);
    }

    public void getBanmiInfo(String token,int id,int page){
        model.getBanmiInfo(token, id, page, new ResultCallBack<BanmiInfo>() {
            @Override
            public void onSuccess(BanmiInfo bean) {
                if (mMvpView != null){
                    mMvpView.onSuccess(bean);
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
}
