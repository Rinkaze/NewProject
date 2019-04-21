package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.SelectionsBean;
import com.jiyun.model.SelectionsModel;
import com.jiyun.net.Callback;
import com.jiyun.view.GankView;
import com.jiyun.view.SelectionsView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class SelectionsPresenter extends BasePresenter<SelectionsView> {

    SelectionsModel model;
    private static final String TAG = "SelectionsPresenter";

    @Override
    public void initModel() {
        model = new SelectionsModel();
        models.add(model);
    }

    public void getSelectionsData(){
        model.getSelectionsData(new Callback<SelectionsBean>() {
            @Override
            public void onSuccess(SelectionsBean data) {
                mMvpView.updateUi(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg);
            }
        });
    }
}
