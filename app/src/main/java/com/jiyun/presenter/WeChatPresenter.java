package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.WechatBean;
import com.jiyun.model.WeChatModel;
import com.jiyun.net.Callback;
import com.jiyun.view.MainView;
import com.jiyun.view.WeChatView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class WeChatPresenter extends BasePresenter<WeChatView> {

    WeChatModel model;
    private static final String TAG = "WeChatPresenter";

    @Override
    public void initModel() {
        model = new WeChatModel();
    }

    public void getWechatData(int page) {
        model.getWechatData(page, new Callback<WechatBean>() {
            @Override
            public void onSuccess(WechatBean data) {
                mMvpView.updateUi(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e=" + msg);
            }
        });
    }

    public void getSearchWechatData(int page, String word) {
        model.getSearchWechatData(page, word, new Callback<WechatBean>() {
            @Override
            public void onSuccess(WechatBean data) {
                mMvpView.updateUi(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e=" + msg);
            }
        });
    }
}
