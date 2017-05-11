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
        searchRecyclerView.setAdapter(new HomeAdapter(this));
    }

    @Override
    protected SearchActivityPresent createPresenter() {
        return new SearchActivityPresent();
    }
}
