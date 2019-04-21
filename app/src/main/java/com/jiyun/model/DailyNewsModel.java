package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.DailyNewsBean;
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

public class DailyNewsModel extends BaseModel {

    public void getDailyNewsData(final Callback<DailyNewsBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhihuService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhihuService zhihuService = retrofit.create(ZhihuService.class);
        Observable<DailyNewsBean> observable = zhihuService.getLastDailyNews();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        callback.onSuccess(dailyNewsBean);
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

    public void getLastNewsData(String date, final Callback<DailyNewsBean> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhihuService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhihuService zhihuService = retrofit.create(ZhihuService.class);
        Observable<DailyNewsBean> observable = zhihuService.getBeforeNews(date);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        callback.onSuccess(dailyNewsBean);
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
