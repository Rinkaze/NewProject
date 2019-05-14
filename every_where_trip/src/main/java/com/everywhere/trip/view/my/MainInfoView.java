package com.everywhere.trip.view.my;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.MainDataInfo;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface MainInfoView extends BaseMvpView {
    void updateUi(MainDataInfo.ResultEntity entity);
    void onSuccess(String msg);
    void onFail(String msg);
}
