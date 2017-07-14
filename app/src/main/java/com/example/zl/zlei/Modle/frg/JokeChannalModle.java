package com.example.zl.zlei.Modle.frg;

import android.content.Context;

import com.example.zl.zlei.adapter.JokeMultyItemBean;
import com.example.zl.zlei.bean.JokeTextBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by zl on 2017/5/8.
 */

public interface JokeChannalModle {
     Observable<JokeTextBean> loadData(String channel, int pagenum, int pagesize, String sort, String appkey);
     ArrayList<JokeMultyItemBean> convert(List<JokeTextBean.ResultBean.ListBean> beanList);
     boolean checkNetIsOK(Context context);
}
