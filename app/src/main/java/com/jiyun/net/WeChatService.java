package com.jiyun.net;

import com.jiyun.bean.WechatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 灵风 on 2019/4/18.
 */

public interface WeChatService {

    String baseUrl = "http://api.tianapi.com/";

    @GET("wxnew/")
    Observable<WechatBean> getWechatNews(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    @GET("wxnew/")
    Observable<WechatBean> getSearchWechatNews(@Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);
}
