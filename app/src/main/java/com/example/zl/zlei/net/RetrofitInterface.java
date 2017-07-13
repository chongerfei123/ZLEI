package com.example.zl.zlei.net;

import com.example.zl.zlei.bean.JokeTextBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zl on 2017/7/12.
 */

public interface RetrofitInterface {
    //http://api.jisuapi.com/xiaohua/text?pagenum=1&pagesize=1&sort=addtime&appkey=yourappkey
    @GET("xiaohua/text?/")
    Observable<JokeTextBean> getTextData(@Query("pagenum") int pagenum, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("appkey") String appkey);
}
