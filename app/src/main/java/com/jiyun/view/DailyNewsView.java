package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.DailyNewsBean;

/**
 * Created by 灵风 on 2019/4/3.
 */

public interface DailyNewsView extends BaseMvpView {
    void updateData(DailyNewsBean dailyNewsBean);
}
