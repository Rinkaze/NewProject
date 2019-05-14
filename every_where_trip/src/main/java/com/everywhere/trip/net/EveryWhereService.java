package com.everywhere.trip.net;

import com.everywhere.trip.bean.BanmiBean;
import com.everywhere.trip.bean.BanmiInfo;
import com.everywhere.trip.bean.BundlesBean;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.bean.LoginInfo;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.bean.MainDataInfo;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xts
 *         Created by asus on 2019/5/3.
 */

public interface EveryWhereService {

    public static final int SUCCESS_CODE = 0;
    public static final int VERIFY_CODE_ERROR = 200502;
    public static final int WECHAT_HAVE_BINDED = 20171102;
    //token 失效
    public static final int TOKEN_EXPIRE = 20170707;
    //余额不足
    public static final int MONEY_NOT_ENOUGH = 200607;
     String BASE_URL = "http://api.banmi.com/";


    /**
     * 微信登录
     *
     * @param unionID
     * @return
     */
    @FormUrlEncoded
    @POST("api/3.0/account/login/wechat")
    Observable<LoginInfo> postWechatLogin(@Field("unionID") String unionID);

    /**
     * 微博登录
     *
     * @param oAuthToken 就是三方里面的uid
     * @return
     */
    @FormUrlEncoded
    @POST("api/3.0/account/login/oauth")
    Observable<LoginInfo> postWeiboLogin(@Field("oAuthToken") String oAuthToken);

    @GET("api/3.0/content/routesbundles")
    Observable<MainDataBean> getMainData(@Query("page") int page, @Header("banmi-app-token")String token);

    @GET("api/3.0/banmi")
    Observable<BanmiBean> getBanmiData(@Query("page") int page, @Header("banmi-app-token")String token);

    @FormUrlEncoded
    @POST("api/3.0/account/updateInfo")
    Observable<ResponseBody> updateInfo(@Header("banmi-app-token")String token, @FieldMap HashMap<String,String> map);

    @POST("api/3.0/banmi/{banmiId}/follow")
    Observable<String> addFollow(@Header("banmi-app-token")String token, @Path("banmiId")int id);

    @POST("api/3.0/banmi/{banmiId}/unfollow")
    Observable<String> disFollow(@Header("banmi-app-token")String token, @Path("banmiId")int id);

    @GET("api/3.0/account/followedBanmi")
    Observable<BanmiBean> getFollowData(@Header("banmi-app-token")String token, @Query("page") int page);

    @GET("api/3.0/content/routes/{routeId}")
    Observable<MainDataInfo> getMainDataInfo(@Header("banmi-app-token")String token,@Path("routeId")int id);

    @POST("api/3.0/content/routes/{routeId}/like")
    Observable<String> addLike(@Header("banmi-app-token")String token, @Path("routeId")int id);

    @POST("api/3.0/content/routes/{routeId}/dislike")
    Observable<String> disLike(@Header("banmi-app-token")String token, @Path("routeId")int id);

    @GET("api/3.0/account/collectedRoutes")
    Observable<LikeBean> getCollectData(@Header("banmi-app-token")String token, @Query("page") int page);

    @GET("api/3.0/banmi/{banmiId}")
    Observable<BanmiInfo> getBanmiInfo(@Header("banmi-app-token")String token,@Path("banmiId")int id,@Query("page")int page);

    @GET("api/3.0/banmi/{banmiId}/routes")
    Observable<MainDataBean> getLineInfo(@Header("banmi-app-token")String token,@Path("banmiId")int id, @Query("page") int page);

    @GET("api/3.0/content/routes/{routeId}/reviews")
    Observable<MainDataInfo> getReviews(@Header("banmi-app-token")String token,@Path("routeId")int id,@Query("page")int page);

    @GET("api/3.0/content/bundles")
    Observable<BundlesBean> getBundles(@Header("banmi-app-token")String token);
}
