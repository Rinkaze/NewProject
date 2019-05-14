package com.everywhere.trip.view.main;

import android.app.Activity;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.LoginInfo;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface LoginOrBindView extends BaseMvpView {
    String getPhone();
    Activity getAct();

    void toastShort(String string);

    void go2MainActivity(LoginInfo.ResultBean result);

    void setData(String data);
}
