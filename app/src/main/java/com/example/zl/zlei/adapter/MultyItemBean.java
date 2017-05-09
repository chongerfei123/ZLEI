package com.example.zl.zlei.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.zl.zlei.bean.DataBean;

import okhttp3.Address;

/**
 * Created by zl on 2017/5/8.
 */

public class MultyItemBean extends MultiItemEntity{
    DataBean.ResultBean.ListBean bean;
    public MultyItemBean(DataBean.ResultBean.ListBean bean) {
        super();
        this.bean = bean;

    }

    @Override
    public int getItemType() {
        return super.getItemType();
    }

    @Override
    public void setItemType(int itemType) {
        super.setItemType(itemType);
    }
}
