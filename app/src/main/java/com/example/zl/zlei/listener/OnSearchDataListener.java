package com.example.zl.zlei.listener;

import com.example.zl.zlei.adapter.MultyItemBean;
import com.example.zl.zlei.adapter.SearchMultyItemBean;

import java.util.ArrayList;

/**
 * Created by zl on 2017/5/8.
 */

public interface OnSearchDataListener {
    void OnSucceed(ArrayList<SearchMultyItemBean> data);
    void OnError(Throwable e);
}
