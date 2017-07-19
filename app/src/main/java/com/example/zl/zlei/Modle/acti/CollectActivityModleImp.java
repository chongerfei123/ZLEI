package com.example.zl.zlei.Modle.acti;

import android.content.Context;

import com.example.zl.zlei.adapter.CollectMultyBean;
import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.bean.SearchDataBean;
import com.example.zl.zlei.others.CacheBeanToSD;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by zl on 2017/7/18.
 */

public class CollectActivityModleImp implements CollectActivityModle {
    @Override
    public Observable<ArrayList<CollectMultyBean>> loadDataFromSD(final Context context) {
        final ArrayList<CollectMultyBean> data = new ArrayList<>();
        final CacheBeanToSD cacheBeanToSD = new CacheBeanToSD(context);

       return Observable.create(new Observable.OnSubscribe<ArrayList<CollectMultyBean>>() {
            @Override
            public void call(Subscriber<? super ArrayList<CollectMultyBean>> subscriber) {
                ArrayList<DataBean.ResultBean.ListBean> dataBean = cacheBeanToSD.getStorageData("dataBean");
                for (DataBean.ResultBean.ListBean item:dataBean) {
                    if (item.getPic().equals("")){
                        data.add(new CollectMultyBean(CollectMultyBean.COLL_MAINNEW_NOPIC,item));
                    }else{
                        data.add(new CollectMultyBean(CollectMultyBean.COLL_MAINNEW,item));
                    }
                }

                ArrayList<SearchDataBean.ResultBean.ListBean> storageSearchData = cacheBeanToSD.getStorageSearchData("searchDataBean");
                for (SearchDataBean.ResultBean.ListBean item: storageSearchData ) {
                    if (item.getPic().equals("")){
                        data.add(new CollectMultyBean(CollectMultyBean.COLL_SEARCH_0PIC,item));
                    }else {
                        data.add(new CollectMultyBean(CollectMultyBean.COLL_SEARCH_1PIC,item));
                    }
                }

                subscriber.onNext(data);
                subscriber.onCompleted();
            }
        });
    }
}
