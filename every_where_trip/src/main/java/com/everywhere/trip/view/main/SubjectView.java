package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.BundlesBean;

/**
 * Created by 灵风 on 2019/5/13.
 */

public interface SubjectView extends BaseMvpView {
    void onSuccess(BundlesBean.ResultEntity entity);
    void onFail(String msg);
}
