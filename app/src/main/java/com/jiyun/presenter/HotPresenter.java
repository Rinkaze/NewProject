package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.HotBean;
import com.jiyun.model.HotModel;
import com.jiyun.net.Callback;
import com.jiyun.view.GankView;
import com.jiyun.view.HotView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class HotPresenter extends BasePresenter<HotView> {

    HotModel model;
    private static final String TAG = "HotPresenter";

    @Override
    public void initModel() {
        model = new HotModel();
    }

    public void getHotData(){
        model.getHotData(new Callback<HotBean>() {
            @Override
            public void onSuccess(HotBean data) {
                if (mMvpView != null && data != null){
                    mMvpView.updateUi(data);
                }
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg);
            }
        });
    }
}
