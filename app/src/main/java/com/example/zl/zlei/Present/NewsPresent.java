package com.example.zl.zlei.Present;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.zl.zlei.Modle.acti.MainModleImp;
import com.example.zl.zlei.View.activi.NewsViewActivity;

/**
 * Created by zl on 2017/5/1.
 */

public class NewsPresent extends BasePresenter<NewsViewActivity> {
    private NewsViewActivity newsViewActivity;
    private MainModleImp mainModleImp;
    public NewsPresent(NewsViewActivity newsViewActivity) {
        this.newsViewActivity = newsViewActivity;
        mainModleImp = new MainModleImp();
    }

    public void changeFragment(Fragment fragment, FragmentManager fragmentManager) {
        mainModleImp.changeFragment(fragment,fragmentManager);
    }
}
