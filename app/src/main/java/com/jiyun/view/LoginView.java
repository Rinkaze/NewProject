package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.LoginBean;

/**
 * Created by 灵风 on 2019/4/2.
 */

public interface LoginView extends BaseMvpView{

    String getUserName();

    String getPsw();

    void showToast(String msg);
}
