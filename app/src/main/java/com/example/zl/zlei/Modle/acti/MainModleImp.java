package com.example.zl.zlei.Modle.acti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.List;

/**
 * Created by zl on 2017/5/1.
 */

public class MainModleImp implements MainModle{
    @Override
    public void changeFragment(Fragment fragment, FragmentManager fragmentManager) {
        List<Fragment> fragmentList = fragmentManager.getFragments();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        String fragmentTag = fragment.getTag();
        for (Fragment fragment1: fragmentList) {
            String fragment1Tag = fragment1.getTag();
            if (!fragment1.isHidden()){
                //fragment1没有被隐藏
                if (fragment1Tag.equals(fragmentTag)){
                    Log.d("sout","要切换的fragment正在被显示");
                    //要切换的fragment正在被显示
                    // TODO: 2017/5/1 更新数据
                }else {
                    transaction.hide(fragment1);
                }
            }
        }
        transaction.show(fragment);
        transaction.commit();
    }
}
