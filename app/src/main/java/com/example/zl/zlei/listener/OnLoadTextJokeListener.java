package com.example.zl.zlei.listener;

import com.example.zl.zlei.adapter.JokeMultyItemBean;

import java.util.ArrayList;

/**
 * Created by zl on 2017/7/13.
 */

public interface OnLoadTextJokeListener {
    void OnSucceed(ArrayList<JokeMultyItemBean> data);
    void OnError(Exception e);
}
