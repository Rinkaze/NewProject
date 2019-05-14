package com.everywhere.trip.net;

import com.everywhere.trip.bean.VerifyCodeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author xts
 *         Created by asus on 2019/4/2.
 */

public interface ApiService {
    String sBaseUrl = "http://yun918.cn/study/public/index.php/";

    /**
     * 获取验证码
     * @return
     */
    @GET("verify")
    Observable<VerifyCodeBean> getVerifyCode();
}
