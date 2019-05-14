package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.bean.MainDataInfo;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface ReviewsView extends BaseMvpView {
    void onSuccess(MainDataInfo.ResultEntity resultEntity);
    void onFail(String msg);
}
