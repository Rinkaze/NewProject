package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.DailyNewsBean;
import com.jiyun.model.DailyNewsModel;
import com.jiyun.net.Callback;
import com.jiyun.view.DailyNewsView;
import com.jiyun.view.GankView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class DailyNewsPresenter extends BasePresenter<DailyNewsView> {

    DailyNewsModel model;
    private static final String TAG = "DailyNewsPresenter";

    @Override
    public void initModel() {
        model = new DailyNewsModel();
        models.add(model);
    }

    public void getDailyNewsData(){
        model.getDailyNewsData(new Callback<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean data) {
                mMvpView.updateData(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg );
            }
        });
    }

    public void getLastNewsData(String date){
        model.getLastNewsData(date, new Callback<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean data) {
                mMvpView.updateData(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg );
            }
        });
    }
}
