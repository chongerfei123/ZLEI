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

    }
}
