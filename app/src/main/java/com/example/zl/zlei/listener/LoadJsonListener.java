package com.example.zl.zlei.listener;

/**
 * Created by zl on 2017/5/8.
 */

public interface LoadJsonListener {
    void OnSucceed(String json);
    void OnError(Exception e);
}
