package com.example.zl.zlei.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zl.zlei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zl on 2017/5/8.
 */

public class MyRecyclerAdapter extends BaseMultiItemQuickAdapter<MultyItemBean> {
    private Context context;

    public MyRecyclerAdapter(List<MultyItemBean> data) {
        super(data);
        addItemType(MultyItemBean.TYPE_pic,R.layout.rec_item);
        addItemType(MultyItemBean.TYPE2_nopic,R.layout.rec_item_nopic);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MultyItemBean multyItemBean) {

        baseViewHolder.setText(R.id.title,multyItemBean.bean.getTitle());
        baseViewHolder.setText(R.id.src,multyItemBean.bean.getSrc());
        baseViewHolder.setText(R.id.category,multyItemBean.bean.getCategory());
        ImageView icon = baseViewHolder.getView(R.id.icon);
        String pic = multyItemBean.bean.getPic();

        switch (baseViewHolder.getItemViewType()) {
            case 1:
                if (pic != null && !pic.equals("") ){
                    Picasso.with(context).load(pic).fit().placeholder(R.mipmap.ic_launcher_round).into(icon);
                }
                break;
            case 2:break;
        }


        //Log.e("sout","convert");
    }
}
