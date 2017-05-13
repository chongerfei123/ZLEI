package com.example.zl.zlei.View.frg.channalfrg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.zl.zlei.R;
import com.example.zl.zlei.adapter.MyRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zl on 2017/5/8.
 */

public class EducationFragment extends TopFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.errorView)
    RelativeLayout errorView;
    @BindView(R.id.channal_progress)
    ProgressBar channalProgress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.education, container, false);
        super.unbinder = ButterKnife.bind(this, view);
        super.adapter = new MyRecyclerAdapter(null);
        super.recyclerView = this.recyclerView;
        super.channal = "教育";
        super.swipeRefreshLayout = swipeRefreshLayout;
        super.errorView = errorView;
        super.channalProgress = channalProgress;
        return view;
    }

}
