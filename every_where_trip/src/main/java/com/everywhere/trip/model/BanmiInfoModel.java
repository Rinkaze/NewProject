package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/12.
 */

public class BanmiInfoModel extends BaseModel {
    private static final String TAG = "BanmiInfoModel";

    public void getBanmiInfo(String token, int id, int page, final ResultCallBack<BanmiInfo> callBack){
        EveryWhereService apiserver = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        apiserver.getBanmiInfo(token,id,page)
                .compose(RxUtils.<BanmiInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<BanmiInfo>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: e="+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BanmiInfo banmiInfo) {
                        if (banmiInfo != null){
                            if (banmiInfo.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(banmiInfo);
                            }else {
                                callBack.onFail(banmiInfo.getDesc());
                            }
                        }
                    }
                });
    }
}
