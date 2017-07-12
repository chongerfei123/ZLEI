package com.example.zl.zlei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.zl.zlei.View.frg.JokesFragment;
import com.example.zl.zlei.View.frg.NewsFragment;
import com.example.zl.zlei.View.frg.SettingFragment;

/**
 * Created by zl on 2017/5/13.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private NewsFragment newsFragment;
    private JokesFragment jokesFragment;
    private SettingFragment settingFragment;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.newsFragment = new NewsFragment();
        this.jokesFragment = new JokesFragment();
        this.settingFragment = new SettingFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = newsFragment;
                break;
            case 1:
                fragment = jokesFragment;
                break;
            case 2:
                fragment = settingFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        String name = null;
//        switch (position) {
//            case 0:
//                name = "news";
//                break;
//            case 1:
//                name = "jokes";
//                break;
//            case 2:
//                name = "setting";
//                break;
//        }
//        return name;
//    }

//
//    @Override
//    public int getCount() {
//        return 2;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
////        container.addView(mList.get(position));
////        return mList.get(position);
// //       return super.instantiateItem(container, position);

//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View) object);
//    }
//

}
