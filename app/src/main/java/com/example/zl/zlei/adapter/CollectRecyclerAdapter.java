package com.example.zl.zlei.adapter;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.activi.CollectActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zl on 2017/7/18.
 */

public class CollectRecyclerAdapter extends BaseMultiItemQuickAdapter<CollectMultyBean> {
    private Context context;
    public CollectRecyclerAdapter(List<CollectMultyBean> data) {
        super(data);
        Log.e("sout", "convert:aaaaaaaaaaaaaaaaaaaaaaa");
        addItemType(CollectMultyBean.COLL_JOKE_PIC, R.layout.coll_joke_pic);
        addItemType(CollectMultyBean.COLL_JOKE_TEXT, R.layout.coll_joke_text);
        addItemType(CollectMultyBean.COLL_MAINNEW, R.layout.coll_mainnew_item);
        addItemType(CollectMultyBean.COLL_MAINNEW_NOPIC, R.layout.coll_mainnew_item_nopic);
        addItemType(CollectMultyBean.COLL_SEARCH_0PIC, R.layout.coll_new_search_0pic);
        addItemType(CollectMultyBean.COLL_SEARCH_1PIC, R.layout.coll_new_search_1pic);
        Log.e("sout", "convert:ddddddddddddddddddddddddd");

    }
// Picasso.with(context).load(searchMultyItemBean.bean.getPic()).fit().placeholder(R.mipmap.ic_launcher_round).into(search_image1);
    @Override
    protected void convert(BaseViewHolder baseViewHolder, CollectMultyBean collectMultyBean) {
        Log.e("sout", "convert:ccccccccccccccc");
        int itemType = collectMultyBean.getItemType();
        switch (itemType) {
            case 3:
                Log.e("sout", "convert:ddddddddddddddddd");
                baseViewHolder.setText(R.id.collect_pic_title,collectMultyBean.dataBean.getTitle());
                ImageView collect_pic_pic = baseViewHolder.getView(R.id.collect_pic_pic);
                Picasso.with(context).load(collectMultyBean.dataBean.getPic()).fit().placeholder(R.mipmap.ic_launcher_round).into(collect_pic_pic);
                baseViewHolder.setText(R.id.collect_pic_src,collectMultyBean.dataBean.getSrc());
                baseViewHolder.setText(R.id.collect_pic_category,collectMultyBean.dataBean.getCategory());
            break;
            case 4:
                baseViewHolder.setText(R.id.collect_nopic_title,collectMultyBean.dataBean.getTitle());
                baseViewHolder.setText(R.id.collect_nopic_src,collectMultyBean.dataBean.getSrc());
                baseViewHolder.setText(R.id.collect_nopic_category,collectMultyBean.dataBean.getCategory());
                break;
            case 5:
                baseViewHolder.setText(R.id.collect_search_opic_title,collectMultyBean.srarchDataBean.getTitle());
                baseViewHolder.setText(R.id.collect_search_opic_src,collectMultyBean.srarchDataBean.getSrc());
                baseViewHolder.setText(R.id.collect_search_opic_category,collectMultyBean.srarchDataBean.getCategory());
                baseViewHolder.setText(R.id.collect_search_opic_time,collectMultyBean.srarchDataBean.getTime());
                break;
            case 6:
                baseViewHolder.setText(R.id.collect_search_1pic_title,collectMultyBean.srarchDataBean.getTitle());
                baseViewHolder.setText(R.id.collect_search_1pic_src,collectMultyBean.srarchDataBean.getSrc());
                baseViewHolder.setText(R.id.collect_search_1pic_category,collectMultyBean.srarchDataBean.getCategory());
                baseViewHolder.setText(R.id.collect_search_1pic_time,collectMultyBean.srarchDataBean.getTime());
                ImageView collect_search_1pic_search_image1 = baseViewHolder.getView(R.id.collect_search_1pic_search_image1);
                Picasso.with(context).load(collectMultyBean.srarchDataBean.getPic()).fit().placeholder(R.mipmap.ic_launcher_round).into(collect_search_1pic_search_image1);
                break;
        }

    }

    public void setContext(Context context) {
        this.context = context;
    }
}
