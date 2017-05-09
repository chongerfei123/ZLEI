package com.example.zl.zlei.Present;

import com.example.zl.zlei.Modle.frg.ChannalModle;
import com.example.zl.zlei.Modle.frg.ChannalModleImp;
import com.example.zl.zlei.View.frg.NewsFragmentInterface;
import com.example.zl.zlei.View.frg.channalfrg.ChannalFragmentInterface;
import com.example.zl.zlei.adapter.MultyItemBean;
import com.example.zl.zlei.listener.OnDataListener;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zl on 2017/5/8.
 */

public class ChannalFragmentPresent extends BasePresenter<ChannalFragmentInterface> {
    private ChannalFragmentInterface fragment;
    private ChannalModle modle;

    public ChannalFragmentPresent(ChannalFragmentInterface fragment) {
        this.fragment = fragment;
        modle = new ChannalModleImp();
    }

    public void loadData(String channel, int start, int num, String appkey, final OnDataListener onDataListener) {
        Observable<ArrayList<MultyItemBean>> observable = modle.loadData(channel, start, num, appkey);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ArrayList<MultyItemBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onDataListener.OnError();
            }

            @Override
            public void onNext(ArrayList<MultyItemBean> data) {
                onDataListener.OnSucceed(data);
            }
        });
    }
}
