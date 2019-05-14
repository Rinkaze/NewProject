package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.model.LineModel;
import com.everywhere.trip.model.MainModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.MainView;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class LinePresenter extends BasePresenter<MainView> {

    private LineModel model;

    @Override
    protected void initModel() {
        model = new LineModel();
        mModels.add(model);
    }

    public void getLineData(int id, int page, String token) {
        model.getLineData(token, id, page, new ResultCallBack<MainDataBean>() {
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
