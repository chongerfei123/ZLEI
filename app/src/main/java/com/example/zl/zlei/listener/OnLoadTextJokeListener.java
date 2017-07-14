package com.example.zl.zlei.listener;

import com.example.zl.zlei.adapter.JokeMultyItemBean;
import com.example.zl.zlei.bean.JokeTextBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2017/7/13.
 */

public interface OnLoadTextJokeListener {
    void OnSucceed(ArrayList<JokeMultyItemBean> data);
    void OnError(Exception e);
}
