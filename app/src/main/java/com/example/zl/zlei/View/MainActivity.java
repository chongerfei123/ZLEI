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
import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.others.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseFragmentActivity<MainActivityInterface, MainPresent> implements MainActivityInterface {

    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.main_viewPager)
    ViewPager mainViewPager;
    private boolean mainTabState = false;
    private TabLayout.Tab tab_one;
    private TabLayout.Tab tab_two;
    private TabLayout.Tab tab_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//
        //注册EventBus
        EventBus.getDefault().register(this);
        FragmentManager fm = getSupportFragmentManager();
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(fm);
        mainViewPager.setAdapter(mainPagerAdapter);
        mainViewPager.setOffscreenPageLimit(3);
        mainTab.setupWithViewPager(mainViewPager);

        tab_one = mainTab.getTabAt(0);
        tab_two = mainTab.getTabAt(1);
        tab_three = mainTab.getTabAt(2);
        tab_one.setIcon(getResources().getDrawable(R.drawable.main_bottom_news_blue,null));
        tab_two.setIcon(getResources().getDrawable(R.drawable.main_bottom_joke_gray,null));
        tab_three.setIcon(getResources().getDrawable(R.drawable.main_bottom_set_gray,null));
        tab_one.setTag("news");
        tab_two.setTag("joke");
        tab_three.setTag("set");

        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tag = (String) tab.getTag();
                switch (tag) {
                    case "news":tab.setIcon(getResources().getDrawable(R.drawable.main_bottom_news_blue,null));
                        break;
                    case "joke":tab.setIcon(getResources().getDrawable(R.drawable.main_bottom_joke_blue,null));
                        break;
                    case "set":tab.setIcon(getResources().getDrawable(R.drawable.main_bottom_set_blue,null));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                String tag = (String) tab.getTag();
                switch (tag) {
                    case "news":tab.setIcon(getResources().getDrawable(R.drawable.main_bottom_news_gray,null));
                        break;
                    case "joke":tab.setIcon(getResources().getDrawable(R.drawable.main_bottom_joke_gray,null));
                        break;
                    case "set":tab.setIcon(getResources().getDrawable(R.drawable.main_bottom_set_gray,null));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){
        int message = messageEvent.getMessage();
        if(message == Global.TABCOMING){
            tabComing();
        }else if (message == Global.TABMISSING){
            tabDismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册EventBus事件
        EventBus.getDefault().unregister(this);
    }

}
