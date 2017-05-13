package com.example.zl.zlei.Modle.frg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.zl.zlei.adapter.MultyItemBean;
import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.listener.LoadJsonListener;
import com.example.zl.zlei.net.OkhttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/**
 * Created by zl on 2017/5/8.
 */

public class ChannalModleImp implements ChannalModle {
    @Override
    public Observable<ArrayList<MultyItemBean>> loadData(final String channel, final int start, final int num, final String appkey) {
        Observable<ArrayList<MultyItemBean>> observable = Observable.unsafeCreate(new Observable.OnSubscribe<ArrayList<MultyItemBean>>() {

            @Override
            public void call(final Subscriber<? super ArrayList<MultyItemBean>> subscriber) {
                OkhttpUtil okhttpUtil = OkhttpUtil.getInstance();
                okhttpUtil.getJson(channel, start, num, appkey, new LoadJsonListener() {
                    @Override
                    public void OnSucceed(String json) {
                        List<DataBean.ResultBean.ListBean> list = parseJson(json);
                        ArrayList<MultyItemBean> data = convert(list);
                        if (data != null) {
                            subscriber.onNext(data);
                            subscriber.onCompleted();
                        } else {
                            Log.e("sout", "data为空");
                        }

                    }

                    @Override
                    public void OnError(Exception e) {
                        subscriber.onError(e);
                        Log.e("sout", "加载数据错误");
                    }
                });
            }
        });
        return observable;
    }

    @Override
    public boolean checkNetIsOK(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    private ArrayList<MultyItemBean> convert(List<DataBean.ResultBean.ListBean> list) {

        ArrayList<MultyItemBean> data = new ArrayList<>();
        for (DataBean.ResultBean.ListBean bean : list) {
            if (bean.getPic().equals("")) {
                data.add(new MultyItemBean(MultyItemBean.TYPE2_nopic, bean));
            } else {
                data.add(new MultyItemBean(MultyItemBean.TYPE_pic, bean));
            }

        }
        return data;
    }

    private List<DataBean.ResultBean.ListBean> parseJson(String json) {
        List<DataBean.ResultBean.ListBean> list = null;
        Gson gson = new Gson();
        DataBean dataBean = gson.fromJson(json, DataBean.class);
        String status = dataBean.getStatus();
        if (status.equals("0")) {
            list = dataBean.getResult().getList();
        } else {
            Log.e("sout", "解析Json错误:" + dataBean.getMsg());
        }
        return list;
    }
}
