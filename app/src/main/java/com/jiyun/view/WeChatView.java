package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.WechatBean;

/**
 * Created by 灵风 on 2019/4/3.
 */

public interface WeChatView extends BaseMvpView {
    void updateUi(WechatBean wechatBean);
}
