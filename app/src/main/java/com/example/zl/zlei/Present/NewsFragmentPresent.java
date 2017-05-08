package com.example.zl.zlei.Present;

import com.example.zl.zlei.View.frg.NewsFragment;
import com.example.zl.zlei.View.frg.NewsFragmentInterface;

/**
 * Created by zl on 2017/5/8.
 */

public class NewsFragmentPresent extends BasePresenter<NewsFragmentInterface> {
    NewsFragmentInterface newsFragmentInterface;
    public NewsFragmentPresent(NewsFragmentInterface newsFragmentInterface) {
        super();
        this.newsFragmentInterface = newsFragmentInterface;
    }
}
