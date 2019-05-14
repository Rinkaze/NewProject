package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.util.SpUtil;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/9.
 */

public class LikeModel extends BaseModel {
    private static final String TAG = "LikeModel";

    public void getLikeData(int page, final ResultCallBack<LikeBean> callBack) {
        EveryWhereService apiserver = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        apiserver.getCollectData((String) SpUtil.getParam(Constants.TOKEN, ""), page)
                .compose(RxUtils.<LikeBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LikeBean>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: e=" + msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LikeBean likeBean) {
                        if (likeBean != null) {
                            if (likeBean.getCode() == EveryWhereService.SUCCESS_CODE) {
                                callBack.onSuccess(likeBean);
                            } else {
                                callBack.onFail(likeBean.getDesc());
                            }
                        }
                    }
                });
    }
}
