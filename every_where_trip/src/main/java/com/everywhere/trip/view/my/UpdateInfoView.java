package com.everywhere.trip.view.my;

import com.everywhere.trip.base.BaseMvpView;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface UpdateInfoView extends BaseMvpView {
    void onSuccess(String msg);
    void onFail(String msg);
}
