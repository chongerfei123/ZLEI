package com.example.zl.zlei.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by zl on 2017/5/8.
 */

public class MyRecyclerAdapter extends BaseQuickAdapter<MultyItemBean> {

    public MyRecyclerAdapter(int layoutResId, List<MultyItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MultyItemBean multyItemBean) {

    }
}
