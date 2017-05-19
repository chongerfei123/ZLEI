package com.example.zl.zlei.others;


import android.content.Context;

import com.example.zl.zlei.bean.DataBean;
import com.example.zl.zlei.bean.SearchDataBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by zl on 2017/5/19.
 */

public class CacheBeanToSD {

    Context context;
    public CacheBeanToSD(Context context) {
        this.context = context;
    }

    /**
     * 数据存放在本地
     *
     * @param tArrayList
     */
    public void saveStorage2SDCard(ArrayList tArrayList, String fileName) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            File filesDir = context.getExternalFilesDir("collect");
            String filePath = filesDir.toString();
            File file = new File(filePath, fileName);
            fileOutputStream = new FileOutputStream(file.toString());  //新建一个内容为空的文件
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取本地的List数据
     *
     * @return
     */
    public ArrayList<SearchDataBean.ResultBean.ListBean> getStorageSearchData(String fileName) {
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        ArrayList<SearchDataBean.ResultBean.ListBean> savedArrayList = new ArrayList<>();
        try {
            File filesDir = context.getExternalFilesDir("collect");
            String filePath = filesDir.toString();
            File file = new File(filePath, fileName);
            fileInputStream = new FileInputStream(file.toString());
            objectInputStream = new ObjectInputStream(fileInputStream);
            savedArrayList = (ArrayList<SearchDataBean.ResultBean.ListBean>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return savedArrayList;
    }

    public ArrayList<DataBean.ResultBean.ListBean> getStorageData(String fileName) {
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        ArrayList<DataBean.ResultBean.ListBean> savedArrayList = new ArrayList<>();
        try {
            File filesDir = context.getExternalFilesDir("collect");
            String filePath = filesDir.toString();
            File file = new File(filePath, fileName);
            fileInputStream = new FileInputStream(file.toString());
            objectInputStream = new ObjectInputStream(fileInputStream);
            savedArrayList = (ArrayList<DataBean.ResultBean.ListBean>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return savedArrayList;
    }
}
