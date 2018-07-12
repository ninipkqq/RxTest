package com.dihmed.www.rxtest.model.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by admin on 2018/3/23.
 */

public interface Api {
    //和服务器通讯的接口部分，使用@body是传递自定义的数据类型
    //http://pic.qjimage.com/pm0036/high/pm0036-3960oz.jpg
    @GET
    Observable<ResponseBody> getPicture(@Url String url);
//    @GET
//    Observable<RegisterResponse> regist(@Body RegisterRequest registerRequest);
}
