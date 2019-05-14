package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.MainDataBean;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface MainView extends BaseMvpView {
    void onSuccess(MainDataBean.ResultEntity resultEntity);
    void onFail(String msg);
}
