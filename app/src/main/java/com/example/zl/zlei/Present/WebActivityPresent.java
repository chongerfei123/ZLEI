package com.example.zl.zlei.Present;

import com.example.zl.zlei.Modle.acti.MainModleImp;
import com.example.zl.zlei.Modle.acti.WebActivityModle;
import com.example.zl.zlei.Modle.acti.WebActivityModleImp;
import com.example.zl.zlei.View.activi.MainActivityInterface;
import com.example.zl.zlei.View.activi.WebActivityInterface;

/**
 * Created by zl on 2017/5/1.
 */

public class WebActivityPresent extends BasePresenter<WebActivityInterface> {
    private WebActivityInterface Activity;
    private WebActivityModle modle;
    public WebActivityPresent(WebActivityInterface webActivity) {
        this.Activity = webActivity;
        modle = new WebActivityModleImp();
    }
}
