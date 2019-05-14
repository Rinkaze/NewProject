package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.model.MainModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.EmptyView;
import com.everywhere.trip.view.main.MainView;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private MainModel model;

    @Override
    protected void initModel() {
        model = new MainModel();
        mModels.add(model);
    }

    public void getMainData(int page,String token){
        model.getMainData(page, token, new ResultCallBack<MainDataBean>() {
            @Override
            public void onSuccess(MainDataBean bean) {
                mMvpView.onSuccess(bean.getResult());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
