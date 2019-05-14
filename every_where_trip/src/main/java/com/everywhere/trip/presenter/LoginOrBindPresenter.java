package com.everywhere.trip.presenter;

import android.util.Log;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseApp;
import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.LoginInfo;
import com.everywhere.trip.bean.VerifyCodeBean;
import com.everywhere.trip.model.LoginOrBindModel;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.util.Logger;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.util.ToastUtil;
import com.everywhere.trip.view.main.EmptyView;
import com.everywhere.trip.view.main.LoginOrBindView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class LoginOrBindPresenter extends BasePresenter<LoginOrBindView> {

    private LoginOrBindModel mLoginOrBindModel;

    @Override
    protected void initModel() {
        mLoginOrBindModel = new LoginOrBindModel();
        mModels.add(mLoginOrBindModel);
    }

    public void oauthLogin(SHARE_MEDIA type) {
        UMShareAPI mShareAPI = UMShareAPI.get(mMvpView.getAct());
        mShareAPI.getPlatformInfo(mMvpView.getAct(), type, umAuthListener);
    }

    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            logMap(data);
            if (platform == SHARE_MEDIA.SINA){
                loginSina(data.get("uid"));
            }
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            ToastUtil.showShort(BaseApp.getRes().getString(R.string.oauth_error));
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            ToastUtil.showShort(BaseApp.getRes().getString(R.string.oauth_cancel));
        }
    };
    private static final String TAG = "LoginOrBindPresenter";
    private void loginSina(String s) {
        mLoginOrBindModel.loginSina(s, new ResultCallBack<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo bean) {
                if (bean.getResult() != null){
                    saveUserInfo(bean.getResult());
                    if (mMvpView != null){
                        Log.e(TAG, "onSuccess: token="+bean.getResult().getToken());
                        mMvpView.toastShort(BaseApp.getRes().getString(R.string.login_success));
                        mMvpView.go2MainActivity(bean.getResult());
                    }
                }else {
                    if (mMvpView != null){
                        mMvpView.toastShort(BaseApp.getRes().getString(R.string.login_fail));
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    private void saveUserInfo(LoginInfo.ResultBean bean) {
        SpUtil.setParam(Constants.TOKEN,bean.getToken());
        SpUtil.setParam(Constants.DESC,bean.getDescription());
        SpUtil.setParam(Constants.GENDER,bean.getGender());
        SpUtil.setParam(Constants.USERNAME,bean.getUserName());
        SpUtil.setParam(Constants.EMAIL,bean.getEmail());
        SpUtil.setParam(Constants.PHONE,bean.getPhone());
        SpUtil.setParam(Constants.PHOTO,bean.getPhoto());
    }

    private void logMap(Map<String, String> data) {
        for (Map.Entry<String, String> stringStringEntry : data.entrySet()) {
            Logger.logD("key: "+stringStringEntry.getKey(),", value: "+stringStringEntry.getValue());
        }
    }

    public void getVerifyCode() {
        mLoginOrBindModel.getVerifyCode(new ResultCallBack<VerifyCodeBean>() {
            @Override
            public void onSuccess(VerifyCodeBean bean) {
                mMvpView.setData(bean.getData());
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
