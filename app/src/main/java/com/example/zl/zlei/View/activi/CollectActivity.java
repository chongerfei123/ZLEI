package com.example.zl.zlei.View.activi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zl.zlei.Present.CollectActivityPresent;
import com.example.zl.zlei.R;

public class CollectActivity extends BaseAppCompatActivity<CollectActivityInterface,CollectActivityPresent> implements CollectActivityInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

    }

    @Override
    protected CollectActivityPresent createPresenter() {
        return new CollectActivityPresent(this);
    }
}
