package com.jiyun.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 灵风 on 2019/4/2.
 */

public class BaseModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void onDestroy() {
        compositeDisposable.clear();
    }
}
