package com.example.zl.zlei.View.activi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zl.zlei.Present.WebActivityPresent;
import com.example.zl.zlei.R;

public class WebActivity extends BaseActivity<WebActivityInterface,WebActivityPresent> implements WebActivityInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }

    @Override
    protected WebActivityPresent createPresenter() {
        return new WebActivityPresent(this);
    }
}
