package com.example.zl.zlei.Modle.frg;

import android.content.Context;

import com.example.zl.zlei.adapter.MultyItemBean;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by zl on 2017/5/8.
 */

public interface ChannalModle {

     Observable<ArrayList<MultyItemBean>> loadData(String channel, int start, int num, String appkey);

    boolean checkNetIsOK(Context context);
}
