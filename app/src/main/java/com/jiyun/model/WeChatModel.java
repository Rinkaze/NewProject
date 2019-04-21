package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.WechatBean;
import com.jiyun.net.Callback;
import com.jiyun.net.WeChatService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 灵风 on 2019/4/18.
 */

public class WeChatModel extends BaseModel{

    public void getWechatData(int page, final Callback<WechatBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeChatService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeChatService chatService = retrofit.create(WeChatService.class);
        Observable<WechatBean> observable = chatService.getWechatNews("52b7ec3471ac3bec6846577e79f20e4c", 10, page);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        callback.onSuccess(wechatBean);
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

    public void getSearchWechatData(int page, String word, final Callback<WechatBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeChatService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeChatService chatService = retrofit.create(WeChatService.class);
        Observable<WechatBean> observable = chatService.getSearchWechatNews("52b7ec3471ac3bec6846577e79f20e4c", 10, page,word);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        callback.onSuccess(wechatBean);
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
