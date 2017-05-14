package com.example.zl.zlei.Present;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.example.zl.zlei.Modle.acti.MainModle;
import com.example.zl.zlei.Modle.acti.MainModleImp;
import com.example.zl.zlei.View.activi.MainActivityInterface;

/**
 * Created by zl on 2017/5/1.
 */

public class MainPresent extends BasePresenter<MainActivityInterface> {
    private MainActivityInterface newsViewActivity;
    private MainModle modle;
    public MainPresent(MainActivityInterface newsViewActivity) {
        this.newsViewActivity = newsViewActivity;
        modle = new MainModleImp();
    }
}
