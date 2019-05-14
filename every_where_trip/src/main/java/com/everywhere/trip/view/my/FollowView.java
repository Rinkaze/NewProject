package com.everywhere.trip.view.my;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.bean.LikeBean;

/**
 * Created by 灵风 on 2019/5/7.
 */

public interface FollowView extends BaseMvpView {
    void onSuccess(BanmiBean.ResultEntity entity);
    void onFail(String msg);
}
