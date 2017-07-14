package com.example.zl.zlei.Present;

import android.content.Context;
import android.util.Log;

import com.example.zl.zlei.Modle.frg.JokeChannalModle;
import com.example.zl.zlei.Modle.frg.JokeChannalModleImp;
import com.example.zl.zlei.View.frg.jokefrg.JokeChannalFragmentInterface;
import com.example.zl.zlei.adapter.JokeMultyItemBean;
import com.example.zl.zlei.bean.JokeTextBean;
import com.example.zl.zlei.listener.OnLoadTextJokeListener;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zl on 2017/7/11.
 */

public class JokeChannalFragmentPresent extends BasePresenter<JokeChannalFragmentInterface> {

    private JokeChannalFragmentInterface fragment;
    private JokeChannalModle modle;

    public JokeChannalFragmentPresent(JokeChannalFragmentInterface jokeChannalFragment) {
        this.fragment = jokeChannalFragment;
        modle = new JokeChannalModleImp();
    }

    public void loadData(String channel, int pagenum, int pagesize, String sort, String appkey, final OnLoadTextJokeListener onLoadTextJokeListener) {
        Log.e("sout", "JokeChannalFragmentPresent--loadData: ");
        Observable<JokeTextBean> textBeanObservable = modle.loadData(channel, pagenum, pagesize, sort, appkey);
        if (textBeanObservable != null){
            textBeanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) .subscribe(new Subscriber<JokeTextBean>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    //Log.e("sout", finalChannel +"JokeChannalModleImp--onError: "+"error"+e.getMessage() );
                    onLoadTextJokeListener.OnError((Exception) e);
                }

                @Override
                public void onNext(JokeTextBean jokeTextBean) {
                  //  Log.e("sout", finalChannel +"JokeChannalModleImp--onNext: "+jokeTextBean.getMsg() );
                    List<JokeTextBean.ResultBean.ListBean> beanList = jokeTextBean.getResult().getList();
                    ArrayList<JokeMultyItemBean> data = modle.convert(beanList);
                    onLoadTextJokeListener.OnSucceed(data);
                }
            });
        }
    }

    public boolean checkNetIsOK(Context context) {
        boolean isOK = modle.checkNetIsOK(context);
        return isOK;
    }
}
