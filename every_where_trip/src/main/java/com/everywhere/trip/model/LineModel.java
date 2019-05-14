package com.everywhere.trip.model;


import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/5.
 */

public class LineModel extends BaseModel {
    public void getLineData(String token, int id, int page, final ResultCallBack<MainDataBean> callBack) {
        EveryWhereService service = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        Observable<MainDataBean> observable = service.getLineInfo(token,id,page);
        observable.compose(RxUtils.<MainDataBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MainDataBean>() {
                    @Override
                    public void error(String msg) {
                        callBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(MainDataBean mainDataBean) {
                        if (mainDataBean != null) {
                            if (mainDataBean.getCode() == EveryWhereService.SUCCESS_CODE) {
                                callBack.onSuccess(mainDataBean);
                            } else {
                                callBack.onFail(mainDataBean.getDesc());
                            }
                        }
                    }
                });
    }
}
