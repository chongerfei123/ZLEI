package com.example.zl.zlei.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.bean.SearchDataBean;

/**
 * Created by zl on 2017/5/8.
 */

public class SearchMultyItemBean extends MultiItemEntity{
    public static int TYPE_0pic = 0;
    public static int TYPE_1pic = 1;
    public static int TYPE_2pic = 2;
    public static int TYPE_3pic = 3;
    public SearchDataBean.ResultBean.ListBean bean;
    private int type;
    public SearchMultyItemBean(SearchDataBean.ResultBean.ListBean bean) {
        super();
        this.bean = bean;
    }

    public SearchMultyItemBean(int type, SearchDataBean.ResultBean.ListBean bean) {
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
