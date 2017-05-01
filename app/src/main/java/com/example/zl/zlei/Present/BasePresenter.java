package com.example.zl.zlei.Present;

import java.lang.ref.WeakReference;

/**
 * Created by zl on 2017/4/24.
 */

public abstract class BasePresenter<T> {
    public WeakReference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView() {
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public T getView(){
        return mViewRef.get();
    }
}
