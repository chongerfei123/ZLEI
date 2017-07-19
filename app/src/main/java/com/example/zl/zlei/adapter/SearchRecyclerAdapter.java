package com.example.zl.zlei.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zl.zlei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zl on 2017/5/8.
 */

public class SearchRecyclerAdapter extends BaseMultiItemQuickAdapter<SearchMultyItemBean> {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public SearchRecyclerAdapter(List<SearchMultyItemBean> data) {
        super(data);
        addItemType(SearchMultyItemBean.TYPE_0pic,R.layout.search_0pic);
        addItemType(SearchMultyItemBean.TYPE_1pic,R.layout.search_1pic);
        addItemType(SearchMultyItemBean.TYPE_2pic,R.layout.search_2pic);
        addItemType(SearchMultyItemBean.TYPE_3pic,R.layout.search_3pic);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, SearchMultyItemBean searchMultyItemBean) {



        baseViewHolder.setText(R.id.title,searchMultyItemBean.bean.getTitle());
        baseViewHolder.setText(R.id.src,searchMultyItemBean.bean.getSrc());
        baseViewHolder.setText(R.id.category,searchMultyItemBean.bean.getCategory());
        baseViewHolder.setText(R.id.time,searchMultyItemBean.bean.getTime());

        switch (baseViewHolder.getItemViewType()) {
            case 0:break;
            case 1: ImageView search_image1 = baseViewHolder.getView(R.id.search_image1);
                   // List<String> pics = searchMultyItemBean.bean.getPic();
                    Picasso.with(context).load(searchMultyItemBean.bean.getPic()).fit().placeholder(R.mipmap.ic_launcher_round).into(search_image1);
                break;
//            case 2: ImageView type2search_image1 = baseViewHolder.getView(R.id.search_image1);
//                    ImageView type2search_image2 = baseViewHolder.getView(R.id.search_image2);
//                    List<String> type2pics = searchMultyItemBean.bean.getPic();
//                    Picasso.with(context).load(type2pics.get(0)).fit().placeholder(R.mipmap.ic_launcher_round).into(type2search_image1);
//                    Picasso.with(context).load(type2pics.get(1)).fit().placeholder(R.mipmap.ic_launcher_round).into(type2search_image2);
//                break;
//            case 3: ImageView type3search_image1 = baseViewHolder.getView(R.id.search_image1);
//                    ImageView type3search_image2 = baseViewHolder.getView(R.id.search_image2);
//                    ImageView type3search_image3 = baseViewHolder.getView(R.id.search_image3);
//                    List<String> type3pics = searchMultyItemBean.bean.getPic();
//                    Picasso.with(context).load(type3pics.get(0)).fit().placeholder(R.mipmap.ic_launcher_round).into(type3search_image1);
//                    Picasso.with(context).load(type3pics.get(1)).fit().placeholder(R.mipmap.ic_launcher_round).into(type3search_image2);
//                    Picasso.with(context).load(type3pics.get(2)).fit().placeholder(R.mipmap.ic_launcher_round).into(type3search_image3);
//                break;
        }
    }
}
