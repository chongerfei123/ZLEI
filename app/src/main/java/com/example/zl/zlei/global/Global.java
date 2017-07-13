package com.example.zl.zlei.global;

/**
 * Created by zl on 2017/5/8.
 */

public class Global {

    //http://api.jisuapi.com/news/get?channel=头条&start=0&num=10&appkey=yourappkey
    //http://api.jisuapi.com/news/search?keyword=xx&appkey=03f42e0ee8987c79
    public static String APPKEY = "03f42e0ee8987c79";
    public static String MainURL = "http://api.jisuapi.com/news/get?";
    public static String SearchMainURL = "http://api.jisuapi.com/news/search?";
    public static String BaseTextURL = "http://api.jisuapi.com/";
    public static int ChannalFragmentIntent = 1;
    public static int SearchActivityIntent = 2;
    public static int NUM = 10;
}
