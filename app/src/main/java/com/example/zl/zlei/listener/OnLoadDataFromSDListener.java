package com.example.zl.zlei.listener;

import com.example.zl.zlei.adapter.CollectMultyBean;

import java.util.ArrayList;

/**
 * Created by zl on 2017/7/18.
 */

public interface OnLoadDataFromSDListener {
    void onSucceed(ArrayList<CollectMultyBean> data);
    void onError(Throwable e);
}
