package com.example.zl.zlei.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.bean.SearchDataBean;

/**
 * Created by zl on 2017/7/18.
 */

public class CollectMultyBean extends MultiItemEntity {
    public static int COLL_JOKE_PIC = 1;
    public static int COLL_JOKE_TEXT = 2;
    public static int COLL_MAINNEW = 3;
    public static int COLL_MAINNEW_NOPIC = 4;
    public static int COLL_SEARCH_0PIC = 5;
    public static int COLL_SEARCH_1PIC = 6;

    public int type = -1;
    public DataBean.ResultBean.ListBean dataBean = null;
    public SearchDataBean.ResultBean.ListBean srarchDataBean = null;

    public CollectMultyBean(int type, DataBean.ResultBean.ListBean item) {
        this.type = type;
        this.dataBean = item;
    }

    public CollectMultyBean(int type, SearchDataBean.ResultBean.ListBean item) {
        this.type = type;
        this.srarchDataBean = item;
    }

    public CollectMultyBean(DataBean.ResultBean.ListBean item) {
        super();
        this.dataBean = item;
    }

    public CollectMultyBean(SearchDataBean.ResultBean.ListBean srarchDataBean) {
        super();
        this.srarchDataBean = srarchDataBean;
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
