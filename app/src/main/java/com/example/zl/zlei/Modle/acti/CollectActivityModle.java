package com.example.zl.zlei.Modle.acti;

import android.content.Context;

import com.example.zl.zlei.adapter.CollectMultyBean;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by zl on 2017/7/18.
 */

public interface CollectActivityModle {
    Observable<ArrayList<CollectMultyBean>> loadDataFromSD(Context context);
}
