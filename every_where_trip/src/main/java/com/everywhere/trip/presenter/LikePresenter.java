package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.model.LikeModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.my.LikeView;

/**
 * Created by 灵风 on 2019/5/9.
 */

public class LikePresenter extends BasePresenter<LikeView> {

    private LikeModel model;

    @Override
    protected void initModel() {
        model = new LikeModel();
        mModels.add(model);
    }

    public void getLikeData(int page){
        model.getLikeData(page, new ResultCallBack<LikeBean>() {
            @Override
            public void onSuccess(LikeBean bean) {
                if (mMvpView != null){
                    mMvpView.onSuccess(bean.getResult());
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
