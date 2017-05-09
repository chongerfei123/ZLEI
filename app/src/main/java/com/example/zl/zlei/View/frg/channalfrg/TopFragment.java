package com.example.zl.zlei.View.frg.channalfrg;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.example.zl.zlei.Present.ChannalFragmentPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.frg.BaseFragment;
import com.example.zl.zlei.adapter.HomeAdapter;
import com.example.zl.zlei.adapter.MultyItemBean;
import com.example.zl.zlei.adapter.MyRecyclerAdapter;
import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.listener.OnDataListener;
import com.example.zl.zlei.others.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zl on 2017/5/8.
 */

public class TopFragment extends BaseFragment<ChannalFragmentInterface, ChannalFragmentPresent> implements ChannalFragmentInterface {

    RecyclerView recyclerView;
    Unbinder unbinder;
    public MyRecyclerAdapter adapter;
    public String channal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        unbinder = null;
        adapter = null;
        channal = null;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //http://api.jisuapi.com/news/get?channel=头条&start=0&num=10&appkey=yourappkey
        initRecAndAda();
        mfragmentPresenter.loadData(channal,0, Global.NUM,Global.APPKEY,new OnDataListener(){
            @Override
            public void OnSucceed(ArrayList<MultyItemBean> data) {
                adapter.setNewData(data);
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
}
