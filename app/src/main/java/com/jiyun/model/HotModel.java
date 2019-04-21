package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.HotBean;
import com.jiyun.net.Callback;
import com.jiyun.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class HotModel extends BaseModel {

    public void getHotData(final Callback<HotBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhihuService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhihuService zhihuService = retrofit.create(ZhihuService.class);
        Observable<HotBean> observable = zhihuService.getHotNews();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callback.onSuccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
