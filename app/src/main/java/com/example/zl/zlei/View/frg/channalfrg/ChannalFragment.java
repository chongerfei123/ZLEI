package com.example.zl.zlei.View.frg.channalfrg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zl.zlei.Present.ChannalFragmentPresent;
import com.example.zl.zlei.View.MainActivity;
import com.example.zl.zlei.View.activi.WebActivity;
import com.example.zl.zlei.View.frg.BaseFragment;
import com.example.zl.zlei.adapter.MultyItemBean;
import com.example.zl.zlei.adapter.MyRecyclerAdapter;
import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.listener.OnDataListener;
import com.example.zl.zlei.listener.OnScrollListener;
import com.example.zl.zlei.others.SpaceItemDecoration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Unbinder;

/**
 * Created by zl on 2017/5/8.
 */

public class ChannalFragment extends BaseFragment<ChannalFragmentInterface, ChannalFragmentPresent> implements ChannalFragmentInterface {

    RecyclerView recyclerView;
    Unbinder unbinder;
    public MyRecyclerAdapter adapter;
    public String channal;
    private int currentNum = 0;
    public SwipeRefreshLayout swipeRefreshLayout;
    private OnScrollListener scrollListener;
    public RelativeLayout errorView;
    public ProgressBar channalProgress;
    public TextView noNetView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        unbinder = null;
        adapter = null;
        channal = null;
        swipeRefreshLayout = null;
        errorView = null;
        channalProgress = null;
        noNetView = null;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //对adapter、swipeRefreshLayout、recyclerView的初始化
        initRecAndAda();

        // 检查是否有网络连接
        if (mfragmentPresenter.checkNetIsOK(getContext())) {
            //初始第一次加载数据
            firstLoadData();
        }else {
            noNetView.setVisibility(View.VISIBLE);
        }

        //上拉加载更多
        loadMoreData();
        //下拉刷新
        refreshData();
        //删除Item
        deleteItem();

        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                MultyItemBean item = (MultyItemBean) adapter.getItem(i);
                String src = item.bean.getSrc();
                String url = null;
                if (item.bean.getUrl().equals("") || item.bean.getUrl().contains("jpg?siz")) {
                    url = item.bean.getWeburl();
                }else {
                    url = item.bean.getUrl();
                }
                DataBean.ResultBean.ListBean bean = item.bean;
                intent.putExtra("bean", (Serializable) bean);
                intent.putExtra("src",src);
                intent.putExtra("url",url);
                intent.putExtra("requestCode",Global.ChannalFragmentIntent);
                startActivity(intent);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                MainActivity activity = (MainActivity) getActivity();
                if (dy > 35){
                    activity.tabDismiss();
                }else if (dy < -35){
                    activity.tabComing();
                }

            }
        });
    }

    /**
     * 有一个bug：先删除item，再滑动到底下就不会loadmore了
     */
    private void deleteItem() {
        adapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                adapter.remove(i);
                adapter.notifyItemRemoved(i);
                Toast.makeText(getContext(), view.getId()+"被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 下拉刷新
     */
    private void refreshData() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mfragmentPresenter.loadData(false,channal,0, Global.NUM,Global.APPKEY,new OnDataListener(){
                    @Override
                    public void OnSucceed(ArrayList<MultyItemBean> data) {
                        adapter.setNewData(data);
                        currentNum = Global.NUM;
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    @Override
                    public void OnError() {
                        Log.e("sout","下拉刷新错误");
                    }
                });
            }
        });
    }

    /**
     * 加载更多的逻辑
     * 问题是用这个被废弃的方法可以，但是用没废弃的那个方法就不行不知道为什么
     */
    private void loadMoreData() {
        adapter.setOnLoadMoreListener(10,new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mfragmentPresenter.loadData(false,channal,currentNum, Global.NUM,Global.APPKEY,new OnDataListener(){
                    @Override
                    public void OnSucceed(ArrayList<MultyItemBean> data) {
                        currentNum = currentNum + Global.NUM;
                        adapter.isNextLoad(false);
                        adapter.addData(data);
                        adapter.notifyDataChangedAfterLoadMore(true);
                        adapter.isNextLoad(true);
                    }
                    @Override
                    public void OnError() {
                        Log.e("sout","加载更多错误");
                        // TODO: 2017/5/14 添加一个加载更多错误的尾部局
                    }
                });
            }
        });
    }

    private void firstLoadData() {
        mfragmentPresenter.loadData(true,channal,0, Global.NUM,Global.APPKEY,new OnDataListener(){
            @Override
            public void OnSucceed(ArrayList<MultyItemBean> data) {
                adapter.setNewData(data);
                currentNum = Global.NUM;
            }
            @Override
            public void OnError() {

            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void initRecAndAda() {
        recyclerView.addItemDecoration(new SpaceItemDecoration(30));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setContext(getContext());
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.openLoadMore(10,true);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected ChannalFragmentPresent createPresenter() {
        return new ChannalFragmentPresent(this);
    }

    @Override
    public void showView() {
        errorView.setVisibility(View.INVISIBLE);
        channalProgress.setVisibility(View.INVISIBLE);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorView() {
        errorView.setVisibility(View.VISIBLE);
        channalProgress.setVisibility(View.INVISIBLE);
        swipeRefreshLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress() {
        errorView.setVisibility(View.INVISIBLE);
        channalProgress.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setVisibility(View.INVISIBLE);
    }
}
