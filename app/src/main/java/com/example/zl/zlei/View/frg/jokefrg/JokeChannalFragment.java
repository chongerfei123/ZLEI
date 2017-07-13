package com.example.zl.zlei.View.frg.jokefrg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zl.zlei.Present.JokeChannalFragmentPresent;
import com.example.zl.zlei.View.frg.BaseFragment;
import com.example.zl.zlei.adapter.JokeMultyItemBean;
import com.example.zl.zlei.adapter.JokeRecyclerAdapter;
import com.example.zl.zlei.global.Global;
import com.example.zl.zlei.listener.OnLoadTextJokeListener;
import com.example.zl.zlei.others.SpaceItemDecoration;

import java.util.ArrayList;

import butterknife.Unbinder;

/**
 * Created by zl on 2017/7/11.
 */

public class JokeChannalFragment extends BaseFragment<JokeChannalFragmentInterface,JokeChannalFragmentPresent>implements JokeChannalFragmentInterface {

    public SwipeRefreshLayout swipeRefreshLayout;
    public RecyclerView recyclerView;
    public String Channal;
    public int isFirstComing = -1;
    public JokeRecyclerAdapter adapter;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        unbinder = null;
        View view = null;
        swipeRefreshLayout = null;
        recyclerView = null;
        Channal = null;
        adapter = null;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        if (recyclerView == null){
//            Log.e("sout", Channal+"JokeChannalFragment__initRecAndAda: recyclerView空" );
//        }
        initRecAndAda();
        if (Channal.equals("笑话")) {
            Log.e("sout", "onViewCreated: 加载笑话数据");
            firstLoadData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initRecAndAda() {
//        recyclerView.addItemDecoration(new SpaceItemDecoration(30));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
//        adapter.setContext(getContext());
//        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
//        adapter.openLoadMore(10,true);
//        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light,
//                android.R.color.holo_orange_light,
//                android.R.color.holo_red_light);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("sout", Channal+"setUserVisibleHint: "+isVisibleToUser+","+isFirstComing );
        if (isVisibleToUser && isFirstComing == -1 && Channal != null && !Channal.equals("笑话")){
            isFirstComing++;
            //第一次进入加载数据
            Log.e("sout", Channal + "--setUserVisibleHint: 第一次进入" );
            firstLoadData();
        }
    }

    private void firstLoadData() {
//        Log.e("sout", "JokeChannalFragment--firstLoadData: ");
//        if (mfragmentPresenter == null){
//            Log.e("sout", "JokeChannalFragment--mfragmentPresenter==null");
//        }

            mfragmentPresenter.loadData("笑话",1,10,"addtime", Global.APPKEY, new OnLoadTextJokeListener() {
                @Override
                public void OnSucceed(ArrayList<JokeMultyItemBean> data) {
                     Log.e("sout", "JokeChannalFragment__OnSucceed: "+data.size() );
                     adapter.setNewData(data);
                }

                @Override
                public void OnError(Exception e) {

                }
            });


    }

    @Override
    protected JokeChannalFragmentPresent createPresenter() {
        return new JokeChannalFragmentPresent(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
