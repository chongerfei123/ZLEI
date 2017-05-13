package com.example.zl.zlei.Modle.acti;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.zl.zlei.View.activi.SearchActivity;
import com.example.zl.zlei.View.activi.SearchActivityInterface;
import com.example.zl.zlei.adapter.SearchMultyItemBean;
import com.example.zl.zlei.bean.SearchDataBean;
import com.example.zl.zlei.listener.LoadJsonListener;
import com.example.zl.zlei.net.OkhttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import rx.Observable;
import rx.Subscriber;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by zl on 2017/5/11.
 *
 */

public class SearchAvtivityModleImp implements SearchAvtivityModle {
    @Override
    public Observable<ArrayList<SearchMultyItemBean>> loadData(final String searchContent, final String appkey) {
        Observable<ArrayList<SearchMultyItemBean>> observable = Observable.unsafeCreate(new Observable.OnSubscribe<ArrayList<SearchMultyItemBean>>() {
            @Override
            public void call(final Subscriber<? super ArrayList<SearchMultyItemBean>> subscriber) {
                OkhttpUtil okhttpUtil = OkhttpUtil.getInstance();
                okhttpUtil.getJson(searchContent,appkey, new LoadJsonListener() {
                    @Override
                    public void OnSucceed(String json) {
                        ArrayList<SearchDataBean.ResultBean.ListBean> list = parseJson(json);
                        ArrayList<SearchMultyItemBean> data = convertAndPass(list);
                        if (data != null){
                            subscriber.onNext(data);
                            subscriber.onCompleted();
                        }else{
                            Log.e("sout","data为空");
                        }

                    }

                    @Override
                    public void OnError(Exception e) {
                        subscriber.onError(e);
                        Log.e("sout","加载数据错误");
                    }
                });
            }
        });
        return observable;
    }

    @Override
    public void memoryHistory(String searchContent, SearchActivity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("search_history",MODE_PRIVATE);
        //这里有坑，必须要clear（）；不然不能保存数据
        SharedPreferences.Editor edit = sharedPreferences.edit().clear();
        android.support.v4.util.ArraySet<String> arraySet = new android.support.v4.util.ArraySet<>();
        Set<String> history = sharedPreferences.getStringSet("history", arraySet);
        history.add(searchContent);
        edit.putStringSet("history",history);
        edit.apply();
       // Log.e("sout", "存sp--SearchAvtivityModleImp"+history.size());
    }

    @Override
    public void removehistoryInSP(SearchActivity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("search_history",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit().clear();
        Set<String> history = sharedPreferences.getStringSet("history", null);
        if (history != null){
            history.clear();
            edit.putStringSet("history",history);
            edit.apply();
        }
    }


    private ArrayList<SearchMultyItemBean> convertAndPass(ArrayList<SearchDataBean.ResultBean.ListBean> list) {
        Log.e("sout",list.size()+"--SearchAvtivityModleImp");
        ArrayList<SearchMultyItemBean> data = new ArrayList<>();
        for (SearchDataBean.ResultBean.ListBean bean : list) {

            String url = bean.getUrl();
            String weburl = bean.getWeburl();
            if (TextUtils.isEmpty(url) && TextUtils.isEmpty(weburl)){
                continue;
            }
            if (url.contains("jpg?siz") && TextUtils.isEmpty(weburl)){
                continue;
            }

            List<String> pics = bean.getPic();
            if(pics.size() == 0){
                data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_0pic,bean));
            }else if (pics.size() == 1){
                data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_1pic,bean));
            }else if (pics.size() == 2){
                data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_2pic,bean));
            }else if (pics.size() >= 3){
                data.add(new SearchMultyItemBean(SearchMultyItemBean.TYPE_3pic,bean));
            }
        }
        Log.e("sout",data.size()+"datasize--SearchAvtivityModleImp");
        return data;
    }

    private ArrayList<SearchDataBean.ResultBean.ListBean> parseJson(String json) {
        String replacejson = json;
        if (json.contains("\"pic\":\"\"")){
            Log.e("sout","\"pic\":\"\"");
            replacejson = json.replace("\"pic\":\"\"", "\"pic\":[]");
        }
        if (replacejson.contains("\"pic\":\"\"")){
            Log.e("sout","还有\"pic\":\"\"");
        }

        ArrayList<SearchDataBean.ResultBean.ListBean> list = null;
        Gson gson = new Gson();
        SearchDataBean dataBean = gson.fromJson(replacejson, SearchDataBean.class);
        String status = dataBean.getStatus();
        if (status.equals("0")){
            list = (ArrayList<SearchDataBean.ResultBean.ListBean>) dataBean.getResult().getList();
        }else {
            Log.e("sout","解析Json错误:"+dataBean.getMsg());
        }
        return list;
    }
}
