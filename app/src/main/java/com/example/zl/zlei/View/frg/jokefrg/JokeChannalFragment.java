package com.example.zl.zlei.View.frg.jokefrg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zl.zlei.Present.JokeChannalFragmentPresent;
import com.example.zl.zlei.View.frg.BaseFragment;

/**
 * Created by zl on 2017/7/11.
 */

public class JokeChannalFragment extends BaseFragment<JokeChannalFragmentInterface,JokeChannalFragmentPresent>implements JokeChannalFragmentInterface {

    public SwipeRefreshLayout swipeRefreshLayout;
    public RecyclerView recyclerView;
    public String Channal;
    public int isFirstComing = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        swipeRefreshLayout = null;
        recyclerView = null;
        Channal = null;
        return null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isFirstComing++;
        if (isVisibleToUser && isFirstComing == 0){
            //第一次进入加载数据
            Log.e("sout", Channal + "--setUserVisibleHint: 第一次进入" );

        }
    }

    @Override
    protected JokeChannalFragmentPresent createPresenter() {
        return new JokeChannalFragmentPresent(this);
    }
}
