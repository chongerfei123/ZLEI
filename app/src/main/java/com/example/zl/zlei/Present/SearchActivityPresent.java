package com.example.zl.zlei.Present;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.zl.zlei.Modle.acti.MainModleImp;
import com.example.zl.zlei.Modle.acti.SearchAvtivityModle;
import com.example.zl.zlei.Modle.acti.SearchAvtivityModleImp;
import com.example.zl.zlei.View.activi.MainActivityInterface;
import com.example.zl.zlei.View.activi.SearchActivity;
import com.example.zl.zlei.View.activi.SearchActivityInterface;
import com.example.zl.zlei.adapter.MultyItemBean;
import com.example.zl.zlei.adapter.SearchMultyItemBean;
import com.example.zl.zlei.listener.OnSearchDataListener;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zl on 2017/5/1.
 */

public class SearchActivityPresent extends BasePresenter<SearchActivityInterface> {

    SearchActivityInterface activity;
    SearchAvtivityModle modle;
    public SearchActivityPresent(SearchActivityInterface activity) {
        this.activity = activity;
        modle = new SearchAvtivityModleImp();
    }

    public void loadData(String searchContent, final String appkey, final OnSearchDataListener onSearchDataListener) {
        activity.showProgressBar();
        Observable<ArrayList<SearchMultyItemBean>> observable = modle.loadData(searchContent, appkey);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ArrayList<SearchMultyItemBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onSearchDataListener.OnError(e);
                activity.showError();
                activity.hideProgressBar();
            }

            @Override
            public void onNext(ArrayList<SearchMultyItemBean> data) {
                onSearchDataListener.OnSucceed(data);
                activity.hideProgressBar();
                activity.hideHistoryrecord();
                activity.hideError();
            }
        });
    }
}
