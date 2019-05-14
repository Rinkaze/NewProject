package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.MainDataInfo;
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

public class ReviewsModel extends BaseModel {
    private static final String TAG = "ReviewsModel";

    public void getReviews(int id, int page, final ResultCallBack<MainDataInfo> callBack){
        HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL,EveryWhereService.class)
                .getReviews((String) SpUtil.getParam(Constants.TOKEN,""),id,page)
                .compose(RxUtils.<MainDataInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MainDataInfo>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: e=" + msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(MainDataInfo mainDataInfo) {
                        if (mainDataInfo != null){
                            if (mainDataInfo.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(mainDataInfo);
                            }else {
                                callBack.onFail(mainDataInfo.getDesc());
                            }
                        }
                    }
                });
    }
}
