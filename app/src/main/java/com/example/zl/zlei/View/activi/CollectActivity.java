package com.example.zl.zlei.View.activi;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zl.zlei.Present.CollectActivityPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.adapter.CollectMultyBean;
import com.example.zl.zlei.adapter.CollectRecyclerAdapter;
import com.example.zl.zlei.listener.OnLoadDataFromSDListener;
import com.example.zl.zlei.others.SpaceItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends BaseAppCompatActivity<CollectActivityInterface, CollectActivityPresent> implements CollectActivityInterface {
    @BindView(R.id.collect_recyclerView)
    RecyclerView collectRecyclerView;
    @BindView(R.id.collect_swipeRefreshLayout)
    SwipeRefreshLayout collectSwipeRefreshLayout;
    @BindView(R.id.collect_toolbar_back)
    ImageView collectToolbarBack;
    private CollectRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);
        collectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new CollectRecyclerAdapter(null);
        recyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        collectRecyclerView.addItemDecoration(new SpaceItemDecoration(30));
        collectRecyclerView.setAdapter(recyclerAdapter);
        View view = View.inflate(this, R.layout.test, null);
        recyclerAdapter.addHeaderView(view);
        recyclerAdapter.setContext(this);

        loadData();

        collectSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                collectSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadData() {
        mPresenter.loadDataFromSD(this, new OnLoadDataFromSDListener() {
            @Override
            public void onSucceed(ArrayList<CollectMultyBean> data) {
                Log.e("sout", "onSucceed: " + data.size());
                recyclerAdapter.setNewData(data);
            }

            @Override
            public void onError(Throwable e) {

            }

        });
    }


    @Override
    protected CollectActivityPresent createPresenter() {
        return new CollectActivityPresent(this);
    }

    @OnClick(R.id.collect_toolbar_back)
    public void onCollectToolbarBackClicked() {
        finish();
    }

}
