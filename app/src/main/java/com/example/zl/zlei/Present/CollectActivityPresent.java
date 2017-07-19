package com.example.zl.zlei.Present;

import android.content.Context;

import com.example.zl.zlei.Modle.acti.CollectActivityModle;
import com.example.zl.zlei.Modle.acti.CollectActivityModleImp;
import com.example.zl.zlei.Modle.acti.WebActivityModle;
import com.example.zl.zlei.Modle.acti.WebActivityModleImp;
import com.example.zl.zlei.View.activi.CollectActivityInterface;
import com.example.zl.zlei.View.activi.WebActivityInterface;
import com.example.zl.zlei.adapter.CollectMultyBean;
import com.example.zl.zlei.listener.OnLoadDataFromSDListener;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zl on 2017/5/1.
 */

public class CollectActivityPresent extends BasePresenter<CollectActivityInterface> {
    private CollectActivityInterface Activity;
    private CollectActivityModle modle;
    public CollectActivityPresent(CollectActivityInterface collectActivity) {
        this.Activity = collectActivity;
        modle = new CollectActivityModleImp();
    }

    public void loadDataFromSD(Context context, final OnLoadDataFromSDListener onLoadDataFromSDListener) {
        Observable<ArrayList<CollectMultyBean>> observable = modle.loadDataFromSD(context);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ArrayList<CollectMultyBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoadDataFromSDListener.onError(e);
            }

            @Override
            public void onNext(ArrayList<CollectMultyBean> collectMultyBeen) {
                onLoadDataFromSDListener.onSucceed(collectMultyBeen);
            }
        });
    }
}
