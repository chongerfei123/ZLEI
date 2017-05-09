package com.example.zl.zlei.listener;

import com.example.zl.zlei.adapter.MultyItemBean;

import java.util.ArrayList;

/**
 * Created by zl on 2017/5/8.
 */

public interface OnDataListener {
    void OnSucceed(ArrayList<MultyItemBean> data);
    void OnError();
}
