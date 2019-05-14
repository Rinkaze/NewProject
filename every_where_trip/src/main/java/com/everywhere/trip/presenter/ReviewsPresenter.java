package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.model.MainModel;
import com.everywhere.trip.model.ReviewsModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.MainView;
import com.everywhere.trip.view.main.ReviewsView;
import com.everywhere.trip.view.my.MainInfoView;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class ReviewsPresenter extends BasePresenter<ReviewsView> {

    private ReviewsModel model;

    @Override
    protected void initModel() {
        model = new ReviewsModel();
        mModels.add(model);
    }

    public void getMainData(int id,int page){
        model.getReviews(id, page, new ResultCallBack<MainDataInfo>() {
            @Override
            public void onSuccess(MainDataInfo bean) {
                mMvpView.onSuccess(bean.getResult());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
