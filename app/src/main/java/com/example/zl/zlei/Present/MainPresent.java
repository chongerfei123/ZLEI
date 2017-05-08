package com.example.zl.zlei.Present;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.zl.zlei.Modle.acti.MainModleImp;
import com.example.zl.zlei.View.activi.MainActivityInterface;

/**
 * Created by zl on 2017/5/1.
 */

public class MainPresent extends BasePresenter<MainActivityInterface> {
    private MainActivityInterface newsViewActivity;
    private MainModleImp mainModleImp;
    public MainPresent(MainActivityInterface newsViewActivity) {
        this.newsViewActivity = newsViewActivity;
        mainModleImp = new MainModleImp();
    }

    public void changeFragment(Fragment fragment, FragmentManager fragmentManager) {
        mainModleImp.changeFragment(fragment,fragmentManager);
    }
}
