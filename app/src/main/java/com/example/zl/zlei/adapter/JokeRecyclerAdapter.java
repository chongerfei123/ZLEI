package com.example.zl.zlei.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zl.zlei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zl on 2017/5/8.
 */

public class JokeRecyclerAdapter extends BaseMultiItemQuickAdapter<JokeMultyItemBean> {
    private Context context;

    public JokeRecyclerAdapter(List<JokeMultyItemBean> data, Context context) {
        super(data);
        this.context = context;
        Log.e(TAG, "JokeRecyclerAdapter: ---------" );
        addItemType(JokeMultyItemBean.TEXT,R.layout.joke_text);
        addItemType(JokeMultyItemBean.PIC,R.layout.joke_pic);
        Log.e(TAG, "JokeRecyclerAdapter: +++++++++" );
    }

//    public JokeRecyclerAdapter(List<JokeMultyItemBean> data) {
//        super(data);
//
//    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, JokeMultyItemBean jokeMultyItemBean) {

        Log.e(TAG, "convert: ////////////////////" );
//        baseViewHolder.setText(R.id.title,multyItemBean.bean.getTitle());
//        baseViewHolder.setText(R.id.src,multyItemBean.bean.getSrc());
//        baseViewHolder.setText(R.id.category,multyItemBean.bean.getCategory());
//        ImageView icon = baseViewHolder.getView(R.id.icon);
//        String pic = multyItemBean.bean.getPic();
//
//        switch (baseViewHolder.getItemViewType()) {
//            case 1:
//                if (pic != null && !pic.equals("") ){
//                    baseViewHolder.setOnClickListener(R.id.image_pic, new OnItemChildClickListener());
//                    Picasso.with(context).load(pic).fit().placeholder(R.mipmap.ic_launcher_round).into(icon);
//                }
//                break;
//            case 2:baseViewHolder.setOnClickListener(R.id.image_nopic, new OnItemChildClickListener());break;
//        }
//
//
//        //Log.e("sout","convert");
    }
}
