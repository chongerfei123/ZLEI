package com.example.zl.zlei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zl.zlei.View.frg.jokefrg.ChildAllFragment;
import com.example.zl.zlei.View.frg.jokefrg.ChildJokeFragment;
import com.example.zl.zlei.View.frg.jokefrg.ChildPhotoFragment;
import com.example.zl.zlei.View.frg.jokefrg.JokeChannalFragment;

import java.util.ArrayList;


/**
 * Created by zl on 2017/7/11.
 */

public class JokeApapter extends FragmentPagerAdapter {
    private static ArrayList<String> channalList = new ArrayList<String>(){{add("笑话"); add("趣图");add("精选"); }};
    private Fragment currentFragment = null;
    private ChildAllFragment childAllFragment = null;
    private ChildPhotoFragment childphotoFragment = null;
    private ChildJokeFragment childjokeFragment = null;

    public JokeApapter(FragmentManager fm) {
        super(fm);
        childAllFragment = new ChildAllFragment();
        childphotoFragment = new ChildPhotoFragment();
        childjokeFragment = new ChildJokeFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:currentFragment = childjokeFragment;break;
            case 1:currentFragment = childphotoFragment;break;
            case 2:currentFragment = childAllFragment;break;
        }
        return currentFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channalList.get(position);
    }
}
