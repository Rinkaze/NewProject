package com.jiyun.net;

/**
 * Created by 灵风 on 2019/4/2.
 */

public interface Callback<T> {

    void onSuccess(T data);
    void onFail(String msg);
}
