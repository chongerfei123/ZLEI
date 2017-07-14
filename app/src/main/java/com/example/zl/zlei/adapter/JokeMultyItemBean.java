package com.example.zl.zlei.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.zl.zlei.bean.JokeTextBean;
import com.example.zl.zlei.bean.SearchDataBean;

/**
 * Created by zl on 2017/7/13.
 */
public class JokeMultyItemBean extends MultiItemEntity {
    public static int TEXT = 0;
    public static int PIC = 1;

    public JokeTextBean.ResultBean.ListBean bean;
    private int type;
    public JokeMultyItemBean(JokeTextBean.ResultBean.ListBean bean) {
        super();
        this.bean = bean;
    }

    public JokeMultyItemBean(int type, JokeTextBean.ResultBean.ListBean bean) {
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
