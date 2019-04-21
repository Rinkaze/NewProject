package com.jiyun.net;

import com.jiyun.bean.DailyNewsBean;
import com.jiyun.bean.HotBean;
import com.jiyun.bean.SelectionsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 灵风 on 2019/4/17.
 */

public interface ZhihuService {

    String baseUrl = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DailyNewsBean> getLastDailyNews();

    @GET("sections")
    Observable<SelectionsBean> getSelections();

    @GET("news/hot")
    Observable<HotBean> getHotNews();

    @GET("news/before/{date}")
    Observable<DailyNewsBean> getBeforeNews(@Path("date")String date);
}
