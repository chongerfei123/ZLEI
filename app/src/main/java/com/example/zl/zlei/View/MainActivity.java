package com.example.zl.zlei.View;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.zl.zlei.Present.MainPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.activi.BaseActivity;
import com.example.zl.zlei.View.activi.MainActivityInterface;
import com.example.zl.zlei.View.frg.JokesFragment;
import com.example.zl.zlei.View.frg.NewsFragment;
import com.example.zl.zlei.View.frg.channalfrg.TopFragment;
import com.example.zl.zlei.listener.OnScrollListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainActivityInterface, MainPresent> implements MainActivityInterface {

    @BindView(R.id.radioButton_news)
    RadioButton radioButtonNews;
    @BindView(R.id.radioButton_jokes)
    RadioButton radioButtonJokes;
    @BindView(R.id.frameLayout_fragment)
    FrameLayout frameLayout_fragment;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    private NewsFragment newsFragment;
    private JokesFragment jokesFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentInit();
    }

    @OnClick(R.id.radioButton_news)
    public void radioButtonNewsOnClick() {
        Toast.makeText(this, "radioButtonNewsOnClick", Toast.LENGTH_SHORT).show();
        mPresenter.changeFragment(newsFragment, fragmentManager);
    }

    @OnClick(R.id.radioButton_jokes)
    public void radioButtonJokesOnClick() {
        Toast.makeText(this, "radioButtonJokesOnClick", Toast.LENGTH_SHORT).show();
        mPresenter.changeFragment(jokesFragment, fragmentManager);
    }


    private void FragmentInit() {
        newsFragment = new NewsFragment();
        jokesFragment = new JokesFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout_fragment, newsFragment, "news");
        transaction.add(R.id.frameLayout_fragment, jokesFragment, "jokes");
        transaction.hide(jokesFragment);
        transaction.commit();
    }

    @Override
    protected MainPresent createPresenter() {
        return new MainPresent(this);
    }
}
