package com.example.zl.zlei.Modle.frg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.zl.zlei.adapter.JokeMultyItemBean;
import com.example.zl.zlei.bean.JokeTextBean;
import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.net.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by zl on 2017/5/8.
 */

public class JokeChannalModleImp implements JokeChannalModle {

    @Override
    public Observable<JokeTextBean> loadData(String channel, int pagenum, int pagesize, String sort, String appkey) {
        Log.e("sout", "JokeChannalModleImp--loadData: run");

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Global.BaseTextURL)
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Observable<JokeTextBean> observable = null;
        observable = retrofitInterface.getTextData(pagenum, pagesize, sort, appkey);
//        if (channel.equals("笑话")){
//
//        }else if(channel.equals("趣图")){
//            //observable = retrofitInterface.getData(pagenum, pagesize, sort, appkey);
//        }else if (channel.equals("精选")){
//            //observable = retrofitInterface.getData(pagenum, pagesize, sort, appkey);
//        }
        return observable;
//        final String finalChannel = channel;
//        if (observable != null){
//            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) .subscribe(new Subscriber<JokeTextBean>() {
//                @Override
//                public void onCompleted() {
//
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    Log.e("sout", finalChannel +"JokeChannalModleImp--onError: "+"error"+e.getMessage() );
//                }
//
//                @Override
//                public void onNext(JokeTextBean jokeTextBean) {
//                    Log.e("sout", finalChannel +"JokeChannalModleImp--onNext: "+jokeTextBean.getMsg() );
//                    List<JokeTextBean.ResultBean.ListBean> beanList = jokeTextBean.getResult().getList();
//                    ArrayList<JokeMultyItemBean> data = convert(beanList);
//                }
//            });
//        }


    }

    public ArrayList<JokeMultyItemBean> convert(List<JokeTextBean.ResultBean.ListBean> beanList) {
        ArrayList<JokeMultyItemBean> data = new ArrayList<>();
        for (JokeTextBean.ResultBean.ListBean bean: beanList) {
            data.add(new JokeMultyItemBean(JokeMultyItemBean.TEXT,bean));
        }
        return data;
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

}
