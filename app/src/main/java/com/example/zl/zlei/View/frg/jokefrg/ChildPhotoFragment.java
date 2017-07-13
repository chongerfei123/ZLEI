package com.example.zl.zlei.View.frg.jokefrg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zl.zlei.R;
import com.example.zl.zlei.adapter.JokeRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildPhotoFragment extends JokeChannalFragment {

    private int isFirstComing = -1;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    public ChildPhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_joke, container, false);
        // Inflate the layout for this fragment
        super.unbinder = ButterKnife.bind(this, view);
        super.recyclerView = recyclerView;
        super.swipeRefreshLayout = swipeRefreshLayout;
        super.Channal = "趣图";
        super.isFirstComing = isFirstComing;
        super.adapter = new JokeRecyclerAdapter(null,getContext());
        Log.e("sout", "onCreateView: ----------" );
        if (recyclerView == null){
            Log.e("sout", "onCreateView:this.recyclerView;空 ");
        }
        return view;
    }

}

