package com.example.zl.zlei.net;

import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.listener.LoadJsonListener;

import java.io.IOException;

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
        okHttpClient = new OkHttpClient();
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
        final Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loadJsonListener.OnError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                loadJsonListener.OnSucceed(json);
            }
        });
    }
}
