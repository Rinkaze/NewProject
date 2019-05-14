package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.BundlesBean;
import com.everywhere.trip.model.SubjectModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.SubjectView;

/**
 * Created by 灵风 on 2019/5/13.
 */

public class SubjectPresenter extends BasePresenter<SubjectView> {

    private SubjectModel model;

    @Override
    protected void initModel() {
        model = new SubjectModel();
        mModels.add(model);
    }

    public void getBundles(){
        model.getBundles(new ResultCallBack<BundlesBean>() {
            @Override
            public void onSuccess(BundlesBean bean) {
                mMvpView.onSuccess(bean.getResult());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
