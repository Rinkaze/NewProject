package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.BanmiBean;

/**
 * Created by 灵风 on 2019/5/6.
 */

public interface BanmiView extends BaseMvpView{
    void onSuccess(BanmiBean.ResultEntity entity);
    void onFail(String msg);

    void toastShort(String msg);
}
