package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface VerifyView extends BaseMvpView {
    void onSuccess(String data);
    void onFail(String msg);
}
