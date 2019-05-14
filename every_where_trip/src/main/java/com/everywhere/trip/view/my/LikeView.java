package com.everywhere.trip.view.my;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.LikeBean;

/**
 * Created by 灵风 on 2019/5/9.
 */

public interface LikeView extends BaseMvpView {
    void onSuccess(LikeBean.ResultEntity resultEntity);
    void onFail(String msg);
}
