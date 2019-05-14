package com.everywhere.trip.base;

import android.os.Environment;

import java.io.File;

/**
 * Created by asus on 2019/3/5.
 */

public interface Constants {
    //是否为debug状态,正式上线版本需要改为false
    boolean isDebug = true;

    String TITLE = "title";

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "codeest" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
    String DATA = "data";

    String TOKEN = "token";
    String DESC = "desc";
    String USERNAME = "username";
    String GENDER = "gender";
    String PHONE = "phone";
    String EMAIL = "email";
    String PHOTO = "photo";
    String TYPE = "type";
}
