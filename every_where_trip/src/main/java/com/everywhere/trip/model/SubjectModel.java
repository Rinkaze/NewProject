package com.everywhere.trip.model;

import android.content.Context;
import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.BundlesBean;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.util.SpUtil;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/13.
 */

public class SubjectModel extends BaseModel {
    private static final String TAG = "SubjectModel";

    public void getBundles(final ResultCallBack<BundlesBean> callBack){
        HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL,EveryWhereService.class)
                .getBundles((String)SpUtil.getParam(Constants.TOKEN,""))
                .compose(RxUtils.<BundlesBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<BundlesBean>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: e="+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BundlesBean bundlesBean) {
                        if (bundlesBean != null){
                            if (bundlesBean.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(bundlesBean);
                            }else {
                                callBack.onFail(bundlesBean.getDesc());
                            }
                        }
                    }
                });
    }
}
