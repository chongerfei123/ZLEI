package com.example.zl.zlei.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zl.zlei.R;

import java.util.List;

/**
 * Created by zl on 2017/7/13.
 */

public class JokeRecyclerAdapter extends BaseMultiItemQuickAdapter<JokeMultyItemBean>{

    public JokeRecyclerAdapter(List<JokeMultyItemBean> data) {
        super(data);
        addItemType(JokeMultyItemBean.TEXT, R.layout.joke_text);
        addItemType(JokeMultyItemBean.PIC,R.layout.test);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, JokeMultyItemBean jokeMultyItemBean) {
        Log.e("sout", "convert: ///////////////" );
        baseViewHolder.setText(R.id.content,jokeMultyItemBean.bean.getContent());
    }
}
