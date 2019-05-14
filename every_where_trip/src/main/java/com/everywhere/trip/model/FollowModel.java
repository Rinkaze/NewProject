package com.everywhere.trip.model;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/7.
 */

public class FollowModel extends BaseModel {
    public void getLikeData(int page, String token, final ResultCallBack<BanmiBean> callBack) {
        EveryWhereService service = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        service.getFollowData(token, page)
                .compose(RxUtils.<BanmiBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<BanmiBean>() {
                    @Override
                    public void error(String msg) {
                        callBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BanmiBean banmiBean) {
                        if (banmiBean != null) {
                            if (banmiBean.getCode() == EveryWhereService.SUCCESS_CODE) {
                                callBack.onSuccess(banmiBean);
                            } else {
                                callBack.onFail(banmiBean.getDesc());
                            }
                        }
                    }
                });
    }
}
