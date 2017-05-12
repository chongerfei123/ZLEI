package com.example.zl.zlei.View.activi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.zl.zlei.Present.MainPresent;
import com.example.zl.zlei.Present.SearchActivityPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.adapter.HomeAdapter;
import com.example.zl.zlei.adapter.SearchMultyItemBean;
import com.example.zl.zlei.adapter.SearchRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity<SearchActivityInterface, SearchActivityPresent> implements SearchActivityInterface {

    @BindView(R.id.search_recyclerView)
    RecyclerView searchRecyclerView;
    @BindView(R.id.search_toolbar)
    Toolbar searchToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<SearchMultyItemBean> data = new ArrayList<SearchMultyItemBean>();
        data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_3pic,null));
        data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_2pic,null));
        data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_1pic,null));
        data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_0pic,null));
        searchRecyclerView.setAdapter(new SearchRecyclerAdapter(data));
    }

    @Override
    protected SearchActivityPresent createPresenter() {
        return new SearchActivityPresent();
    }
}
