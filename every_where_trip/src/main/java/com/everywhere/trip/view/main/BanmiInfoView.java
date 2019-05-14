package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.BanmiInfo;

/**
 * Created by 灵风 on 2019/5/12.
 */

public interface BanmiInfoView extends BaseMvpView{
    void onSuccess(BanmiInfo banmiInfo);
    void onFail(String msg);
}
