package com.example.zl.zlei.View.frg;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zl.zlei.R;
import com.example.zl.zlei.View.activi.OpenSLActivity;
import com.example.zl.zlei.View.myview.SettingItemView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    @BindView(R.id.openSourceLicense)
    SettingItemView openSourceLicense;
    Unbinder unbinder;
    @BindView(R.id.shareAPP)
    SettingItemView shareAPP;
    @BindView(R.id.contactMe)
    SettingItemView contactMe;
    @BindView(R.id.setting_ClearCache)
    SettingItemView settingClearCache;
    private AlertDialog dialog;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        openSourceLicenseListener();



    }

    private void init() {
        //初始化ShareSDK
        ShareSDK.initSDK(getContext(), "1e019774b0fb0");
        String cache_Str = readCache();
        settingClearCache.setOtherText(cache_Str);
    }

    private String readCache() {
        File file = new File(String.valueOf(getContext().getCacheDir()));
        long size = getFolderSize(file);
        String fileSize = Formatter.formatFileSize(getContext(), size);
//        Log.e("sout", "readCache: "+size +"---"+fileSize);
        return fileSize;
    }


    /**
     * 获取文件夹大小
     *
     * @param file File实例
     * @return long
     */
    public long getFolderSize(File file) {

        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);

                } else {
                    size = size + fileList[i].length();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }


    private void openSourceLicenseListener() {
        openSourceLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OpenSLActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.shareAPP)
    public void onshareAPPClicked() {
        ShareSDK.initSDK(getActivity());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(getActivity());
    }

    @OnClick(R.id.contactMe)
    public void oncontactMeClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View contact_me = View.inflate(getContext(), R.layout.contactme, null);
        Button contactButtonBack = (Button) contact_me.findViewById(R.id.contactme_button_back);
        builder.setView(contact_me);
        dialog = builder.show();
        contactButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @OnClick(R.id.setting_ClearCache)
    public void settingClearCache() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("确认清除吗？");
        builder.setIcon(R.drawable.contact_dialog_deletecache);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                settingClearCache.setOtherText("暂无");
                deleteFolderFile(String.valueOf(getActivity().getCacheDir()),true);
            }
        });
        builder.show();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            String cache_Str = readCache();
            settingClearCache.setOtherText(cache_Str);
        }
    }

    /**
     * 删除指定目录下文件及目录
     * @param deleteThisPath
     * @param filePath
     * @return
     */
    public void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) {// 处理目录
                    File files[] = file.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        deleteFolderFile(files[i].getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {// 如果是文件，删除
                        file.delete();
                    } else {// 目录
                        if (file.listFiles().length == 0) {// 目录下没有文件或者目录，删除
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
