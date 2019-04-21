package com.jiyun.net;

import com.jiyun.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 灵风 on 2019/4/2.
 */

public interface ApiService {

    String baseUrl = "http://yun918.cn/study/public/index.php/";

    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username")String username,@Field("password")String password);

}
