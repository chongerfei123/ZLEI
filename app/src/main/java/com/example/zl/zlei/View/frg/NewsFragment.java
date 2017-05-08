package com.example.zl.zlei.View.frg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zl.zlei.Present.NewsFragmentPresent;
import com.example.zl.zlei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NewsFragmentInterface,NewsFragmentPresent> implements NewsFragmentInterface {


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    protected NewsFragmentPresent createPresenter() {
        return null;
    }
}
