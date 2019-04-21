package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.SelectionsBean;
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

public class SelectionsModel extends BaseModel {

    public void getSelectionsData(final Callback<SelectionsBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhihuService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ZhihuService zhihuService = retrofit.create(ZhihuService.class);
        Observable<SelectionsBean> observable = zhihuService.getSelections();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SelectionsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SelectionsBean selectionsBean) {
                        callback.onSuccess(selectionsBean);
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
