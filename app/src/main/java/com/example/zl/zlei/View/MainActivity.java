package com.example.zl.zlei.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.zl.zlei.Present.NewsPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.activi.BaseActivity;
import com.example.zl.zlei.View.activi.NewsViewActivity;
import com.example.zl.zlei.View.frg.JokesFragment;
import com.example.zl.zlei.View.frg.NewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<NewsViewActivity, NewsPresent> implements NewsViewActivity {

    @BindView(R.id.radioButton_news)
    RadioButton radioButtonNews;
    @BindView(R.id.radioButton_jokes)
    RadioButton radioButtonJokes;
    @BindView(R.id.frameLayout_fragment)
    FrameLayout frameLayout_fragment;

    private NewsFragment newsFragment;
    private JokesFragment jokesFragment;
    private FragmentManager fragmentManager;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        FragmentInit();

    }

    @OnClick(R.id.radioButton_news)
    public void radioButtonNewsOnClick (){
        Toast.makeText(this, "radioButtonNewsOnClick", Toast.LENGTH_SHORT).show();
        mPresenter.changeFragment(newsFragment,fragmentManager);
    }

    @OnClick(R.id.radioButton_jokes)
    public void radioButtonJokesOnClick (){
        Toast.makeText(this, "radioButtonJokesOnClick", Toast.LENGTH_SHORT).show();
        mPresenter.changeFragment(jokesFragment,fragmentManager);
    }


    private void FragmentInit() {
        newsFragment = new NewsFragment();
        jokesFragment = new JokesFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout_fragment,newsFragment,"news");
        transaction.add(R.id.frameLayout_fragment,jokesFragment,"jokes");
        //transaction.hide(jokesFragment);
        transaction.commit();
    }

    @Override
    protected NewsPresent createPresenter() {
        return new NewsPresent(this);
    }
}
