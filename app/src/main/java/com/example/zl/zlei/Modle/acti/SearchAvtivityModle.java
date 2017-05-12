package com.example.zl.zlei.Modle.acti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.zl.zlei.adapter.SearchMultyItemBean;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by zl on 2017/5/1.
 */

public interface SearchAvtivityModle {
    Observable<ArrayList<SearchMultyItemBean>> loadData(String searchContent, String appkey);
}
