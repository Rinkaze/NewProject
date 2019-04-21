package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.HotBean;

/**
 * Created by 灵风 on 2019/4/3.
 */

public interface HotView extends BaseMvpView {
    void updateUi(HotBean hotBean);
}
