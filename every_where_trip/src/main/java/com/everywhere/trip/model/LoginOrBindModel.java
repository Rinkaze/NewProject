package com.everywhere.trip.model;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.bean.LoginInfo;
import com.everywhere.trip.bean.VerifyCodeBean;
import com.everywhere.trip.net.ApiService;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class LoginOrBindModel extends BaseModel {
    public void loginSina(String uid, final ResultCallBack<LoginInfo> callBack) {
        EveryWhereService apiserver = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        apiserver.postWeiboLogin(uid).compose(RxUtils.<LoginInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginInfo>() {
                    @Override
                    public void error(String msg) {

                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginInfo loginInfo) {
                        if (loginInfo != null){
                            if (loginInfo.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(loginInfo);
                            }else {
                                callBack.onFail(loginInfo.getDesc());
                            }
                        }
                    }
                });
    }

    public void getVerifyCode(final ResultCallBack<VerifyCodeBean> callBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        final Observable<VerifyCodeBean> verifyCode = apiserver.getVerifyCode();
        verifyCode.compose(RxUtils.<VerifyCodeBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<VerifyCodeBean>() {
                    @Override
                    public void error(String msg) {

                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(VerifyCodeBean verifyCodeBean) {
                        callBack.onSuccess(verifyCodeBean);
                    }
                });
    }
}
