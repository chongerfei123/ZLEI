package com.example.zl.zlei.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.bean.SearchDataBean;

import java.lang.reflect.Type;

import okhttp3.Address;

/**
 * Created by zl on 2017/5/8.
 */

public class MultyItemBean extends MultiItemEntity{
    public static int TYPE_pic = 1;
    public static int TYPE2_nopic = 2;
    public DataBean.ResultBean.ListBean bean;
    private int type;
    public MultyItemBean(DataBean.ResultBean.ListBean bean) {
        super();
        this.bean = bean;

    }

    public MultyItemBean(int type, DataBean.ResultBean.ListBean bean) {
        this.bean = bean;
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }

    @Override
    public void setItemType(int itemType) {
        this.type = itemType;
    }
}
