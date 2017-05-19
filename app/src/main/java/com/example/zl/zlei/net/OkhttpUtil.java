package com.example.zl.zlei.net;

import android.util.Log;

import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.listener.LoadJsonListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zl on 2017/5/8.
 */

public class OkhttpUtil {
    private static OkHttpClient okHttpClient;
    private static OkhttpUtil okhttpUtil;

    public OkhttpUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10,TimeUnit.SECONDS);
        builder.readTimeout(10,TimeUnit.SECONDS);
        okHttpClient = builder.build();
    }

    public static OkhttpUtil getInstance(){
        if (okhttpUtil == null){
            synchronized (OkhttpUtil.class){
                okhttpUtil = new OkhttpUtil();
            }
        }
        return okhttpUtil;
    }

    public void getJson(String channel, int start, int num, String appkey, final LoadJsonListener loadJsonListener){
       // http://api.jisuapi.com/news/get?channel=头条&start=0&num=10&appkey=yourappkey
        String url = Global.MainURL + "channel=" + channel + "&start=" + start + "&num=" + num + "&appkey=" + appkey;
        callNet(loadJsonListener, url,false);
    }

    /**
     * 请求数据
     * 如果是搜索请求，会重复2次，但是依然解决不了bug，这是数据方的问题，不是我的问题
     * @param loadJsonListener
     * @param url
     * @param isFromSearch
     */
    private void callNet(final LoadJsonListener loadJsonListener, String url, final boolean isFromSearch) {
        final Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
              //  Log.e("sout","失败一次");
                if (isFromSearch){
          //          Log.e("sout","开始第二次");
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            loadJsonListener.OnError(e);
           //                 Log.e("sout","失败2次");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                           String json = response.body().string();
                           loadJsonListener.OnSucceed(json);
            //               Log.e("sout","第二次成功");
                        }
                    });
                }else {
                    loadJsonListener.OnError(e);
                }
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                loadJsonListener.OnSucceed(json);
            //    Log.e("sout","第一次成功");
            }
        });
    }

    public void getJson(String searchContent, String appkey, LoadJsonListener loadJsonListener) {
        //http://api.jisuapi.com/news/search?keyword=xx&appkey=03f42e0ee8987c79
        String url = Global.SearchMainURL + "keyword=" + searchContent + "&appkey=" + appkey;
        callNet(loadJsonListener, url,true);
    }
}
