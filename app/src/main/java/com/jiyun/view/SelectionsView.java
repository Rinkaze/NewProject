package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.SelectionsBean;

/**
 * Created by 灵风 on 2019/4/3.
 */

public interface SelectionsView extends BaseMvpView {
    void updateUi(SelectionsBean selectionsBean);
}
