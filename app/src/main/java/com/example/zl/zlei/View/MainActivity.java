package com.example.zl.zlei.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewPropertyAnimator;

import com.example.zl.zlei.Present.MainPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.activi.BaseFragmentActivity;
import com.example.zl.zlei.View.activi.MainActivityInterface;
import com.example.zl.zlei.adapter.MainPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseFragmentActivity<MainActivityInterface, MainPresent> implements MainActivityInterface {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_viewPager)
    ViewPager mainViewPager;
    private boolean mainTabState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//
        FragmentManager fm = getSupportFragmentManager();
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(fm);
        mainViewPager.setAdapter(mainPagerAdapter);
        mainTab.setupWithViewPager(mainViewPager);
    }

    @Override
    protected MainPresent createPresenter() {
        return new MainPresent(this);
    }

    public void tabDismiss() {
        if (!mainTabState){
            int height = mainTab.getMeasuredHeight();
            ViewPropertyAnimator animate = mainTab.animate();
            animate.setDuration(300);
            animate.translationY(height);
            animate.start();
            mainTabState = true;
        }
    }
    public void tabComing() {
        if (mainTabState){
            ViewPropertyAnimator animate = mainTab.animate();
            animate.setDuration(200);
            animate.translationY(0);
            animate.start();
            mainTabState = false;
        }

    }
}
