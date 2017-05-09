package com.example.zl.zlei.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zl.zlei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zl on 2017/5/8.
 */

public class MyRecyclerAdapter extends BaseQuickAdapter<MultyItemBean> {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public MyRecyclerAdapter(int layoutResId, List<MultyItemBean> data) {
        super(layoutResId, data);

    }

    public MyRecyclerAdapter(List<MultyItemBean> data) {
        super(R.layout.rec_item, data);
    }

    public MyRecyclerAdapter(View contentView, List<MultyItemBean> data) {
        super(contentView, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MultyItemBean multyItemBean) {
        baseViewHolder.setText(R.id.title,multyItemBean.bean.getTitle());
        baseViewHolder.setText(R.id.src,multyItemBean.bean.getSrc());
        baseViewHolder.setText(R.id.category,multyItemBean.bean.getCategory());
        ImageView icon = baseViewHolder.getView(R.id.icon);
        String pic = multyItemBean.bean.getPic();
        if (pic != null && !pic.equals("") ){
            Picasso.with(context).load(pic).fit().placeholder(R.mipmap.ic_launcher_round).into(icon);
        }

        //Log.e("sout","convert");
    }
}
