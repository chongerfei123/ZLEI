package com.example.zl.zlei.Present;

import com.example.zl.zlei.Modle.acti.CollectActivityModle;
import com.example.zl.zlei.Modle.acti.CollectActivityModleImp;
import com.example.zl.zlei.Modle.acti.WebActivityModle;
import com.example.zl.zlei.Modle.acti.WebActivityModleImp;
import com.example.zl.zlei.View.activi.CollectActivityInterface;
import com.example.zl.zlei.View.activi.WebActivityInterface;

/**
 * Created by zl on 2017/5/1.
 */

public class CollectActivityPresent extends BasePresenter<CollectActivityInterface> {
    private CollectActivityInterface Activity;
    private CollectActivityModle modle;
    public CollectActivityPresent(CollectActivityInterface collectActivity) {
        this.Activity = collectActivity;
        modle = new CollectActivityModleImp();
    }
}
