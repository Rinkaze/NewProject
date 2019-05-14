package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.model.FollowModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.my.FollowView;

/**
 * Created by 灵风 on 2019/5/7.
 */

public class FollowPresenter extends BasePresenter<FollowView> {

    private FollowModel model;

    @Override
    protected void initModel() {
        model = new FollowModel();
        mModels.add(model);
    }

    public void getLikeData(String token,int page){
        model.getLikeData(page, token, new ResultCallBack<BanmiBean>() {
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
}
