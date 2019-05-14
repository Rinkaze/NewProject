package com.everywhere.trip.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author xts
 *         Created by asus on 2019/4/2.
 *
 */

public class BaseModel {
    private CompositeDisposable mCompositeDisposable;

    public void onDestory() {
        //切换所有的Disposable对象
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    public void addDisposable(Disposable d){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }
}
