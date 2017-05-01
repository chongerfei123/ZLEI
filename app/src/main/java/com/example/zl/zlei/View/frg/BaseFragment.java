package com.example.zl.zlei.View.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.zl.zlei.Present.BasePresenter;


/**
 * Created by zl on 2017/4/24.
 */

public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment{
    protected T mfragmentPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mfragmentPresenter = createPresenter();
        mfragmentPresenter.attachView((V)this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mfragmentPresenter.detachView();
    }


    protected abstract T createPresenter();
}
