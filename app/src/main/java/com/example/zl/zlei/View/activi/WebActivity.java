package com.example.zl.zlei.View.activi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zl.zlei.Present.WebActivityPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.MainActivity;
import com.example.zl.zlei.others.activityBrightnessManager;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseAppCompatActivity<WebActivityInterface, WebActivityPresent> implements WebActivityInterface {

    @BindView(R.id.fab_mengban)
    TextView fabMengban;
    @BindView(R.id.fab)
    FloatingActionMenu fab;
    @BindView(R.id.toolbarInweb)
    Toolbar toolbarInweb;
    @BindView(R.id.webParent)
    LinearLayout webParent;
    @BindView(R.id.tool_srctext)
    TextView toolSrctext;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.floatingParent)
    RelativeLayout floatingParent;
    @BindView(R.id.setting_button)
    ImageButton settingButton;
    @BindView(R.id.shares_button)
    ImageButton sharesButton;
    @BindView(R.id.settingView)
    RelativeLayout settingView;
    @BindView(R.id.Font_minus)
    TextView FontMinus;
    @BindView(R.id.Font_add)
    TextView FontAdd;
    @BindView(R.id.Font_seekBar)
    SeekBar FontSeekBar;
    @BindView(R.id.Font_default)
    CheckBox FontDefault;
    @BindView(R.id.light_minus)
    ImageButton lightMinus;
    @BindView(R.id.light_add)
    ImageButton lightAdd;
    @BindView(R.id.light_seekBar)
    SeekBar light_seekBar;
    @BindView(R.id.light_default)
    CheckBox lightDefault;
    @BindView(R.id.isHaveImageButton)
    RadioButton isHaveImageButton;
    @BindView(R.id.fresh)
    RadioButton fresh;
    @BindView(R.id.fab_share)
    FloatingActionButton fabShare;
    @BindView(R.id.rotate)
    RadioButton rotate;
    private WebView webView;
    private String src = null;
    private String url = null;
    private WebSettings webSettings;
    private boolean fabToggleState;
    private boolean settingViewState = true;
    private boolean settingViewopenFirst = true;
    private boolean closeLoadImage = false;
    private static boolean isSrceenPORTRAIT = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        init();

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSrceenPORTRAIT){
                    //切换横屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    isSrceenPORTRAIT = false;
                    //Log.e("sout","切换横屏--"+isSrceenPORTRAIT);
                }else {
                    //切换竖屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    isSrceenPORTRAIT = true;
                   // Log.e("sout","切换竖屏--"+isSrceenPORTRAIT);
                }
               // Log.e("sout","setRequestedOrientation--"+isSrceenPORTRAIT);
                closeSettingView();
            }
        });

        fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView != null) {
                    closeSettingView();
                    webView.reload();
                }
            }
        });
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView != null) {
                    fab.close(true);
                    webView.reload();
                }
            }
        });
        isHaveImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeLoadImage = !closeLoadImage;
                if (closeLoadImage) {
                    Drawable top = getResources().getDrawable(R.drawable.ic_menu_gallery, null);
                    isHaveImageButton.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                } else {
                    Drawable top = getResources().getDrawable(R.drawable.ic_menu_camera, null);
                    isHaveImageButton.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                }
            }
        });

        light_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    lightDefault.setChecked(false);
                    float progress1 = progress;
                    float i = progress1 / 100;
                    activityBrightnessManager.setActivityBrightness(i, WebActivity.this);
                    Log.e("sout", "brightness" + i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        lightDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    light_seekBar.setProgress(50);
                    activityBrightnessManager.setActivityBrightness(-1.0f, WebActivity.this);
                }
            }
        });

        lightAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightDefault.setChecked(false);
                float brightness = activityBrightnessManager.getActivityBrightness(WebActivity.this);
                if (brightness == -1.0) {
                    //这是跟随系统亮度
                    activityBrightnessManager.setActivityBrightness(0.5f, WebActivity.this);
                    light_seekBar.setProgress((int) (0.5 * 100));
                } else {
                    brightness = brightness + 0.1f;
                    if (brightness >= 1.0f) {
                        brightness = 0.9999f;
                    }
                    activityBrightnessManager.setActivityBrightness(brightness, WebActivity.this);
                    light_seekBar.setProgress((int) (brightness * 100));
                }
                Log.e("sout", "brightness" + brightness);
            }
        });
        lightMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightDefault.setChecked(false);
                float brightness = activityBrightnessManager.getActivityBrightness(WebActivity.this);
                if (brightness == -1.0) {
                    //这是跟随系统亮度
                    activityBrightnessManager.setActivityBrightness(0.5f, WebActivity.this);
                    light_seekBar.setProgress((int) (0.5 * 100));
                } else {
                    brightness = brightness - 0.1f;
                    if (brightness <= 0f) {
                        brightness = 0.0001f;
                    }
                    activityBrightnessManager.setActivityBrightness(brightness, WebActivity.this);
                    light_seekBar.setProgress((int) (brightness * 100));
                }
                Log.e("sout", "brightness" + brightness);
            }
        });

        //字体的CheckBox的逻辑
        FontDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    webSettings.setTextZoom(100);
                    FontSeekBar.setProgress(50);
                    // Log.e("sout", webSettings.getTextZoom() + "onCheckedChanged" +FontSeekBar.getProgress());
                }
            }
        });
        //字体的seekBar的逻辑
        FontSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    FontDefault.setChecked(false);
                    webSettings.setTextZoom(progress + 50);
                    // Log.e("sout", progress + "fromUser");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //字体的A-的逻辑
        FontMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FontDefault.setChecked(false);
                int textZoom = webSettings.getTextZoom();
                if (textZoom > 50) {
                    textZoom = textZoom - 10;
                } else {
                    textZoom = 50;
                }
                FontSeekBar.setProgress(textZoom - 50);
                webSettings.setTextZoom(textZoom);
                //Log.e("sout", textZoom - 50 + "FontSeekBar");
            }
        });
        //字体的A+的逻辑
        FontAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FontDefault.setChecked(false);
                int textZoom = webSettings.getTextZoom();
                if (textZoom < 150) {
                    textZoom = textZoom + 10;
                } else {
                    textZoom = 150;
                }
                FontSeekBar.setProgress(textZoom - 50);
                webSettings.setTextZoom(textZoom);
                // Log.e("sout", textZoom - 50 + "FontSeekBar");
            }
        });


        //底部设置栏出现的逻辑
        settingView.setVisibility(View.INVISIBLE);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (settingViewopenFirst) {
                    settingView.setVisibility(View.VISIBLE);
                    settingViewopenFirst = false;
                } else {
                    if (settingViewState) {
                        closeSettingView();
                        settingViewState = false;
                    } else {
                        openSettingView();
                        settingViewState = true;
                    }
                }

            }
        });

//        sharesButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                float brightness = activityBrightnessManager.getActivityBrightness(WebActivity.this);
//                Log.e("sout",""+brightness);
//                brightness += 0.1;
//                if (brightness > 1.0){
//                    brightness = 1.0f;
//                }
//                activityBrightnessManager.setActivityBrightness(brightness,WebActivity.this);
//            }
//        });
//        settingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                float brightness = activityBrightnessManager.getActivityBrightness(WebActivity.this);
//                Log.e("sout",""+brightness);
//                brightness -= 0.1;
//                if (brightness < 0){
//                    brightness = -1.0f;
//                }
//                Log.e("sout",""+brightness);
//                activityBrightnessManager.setActivityBrightness(brightness,WebActivity.this);
//            }
//        });

        //左上角返回键
        toolbarInweb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                    webView.goBack();
                } else {
                    Intent intent = new Intent(WebActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        decideMengBanShouldComing();
        Log.e("sout", "onCreate");
        Intent intent = getIntent();
        src = intent.getStringExtra("src");
        url = intent.getStringExtra("url");
        Log.e("sout", src + "--" + url);

    }

    /**
     * 打开底部设置栏的动画
     */
    private void openSettingView() {
//        settingView
        Log.e("sout", "openSettingView");
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(settingView);
        animate.translationY(0);
        animate.setDuration(300);
        AccelerateInterpolator interpolator = new AccelerateInterpolator(1.0f);
        animate.setInterpolator(interpolator);
        animate.start();
    }

    /**
     * 关闭底部设置栏的动画
     */
    private void closeSettingView() {
        Log.e("sout", "closeSettingView");
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(settingView);
        animate.translationY(settingView.getHeight());
        animate.setDuration(300);
        AccelerateInterpolator interpolator = new AccelerateInterpolator(2f);
        animate.setInterpolator(interpolator);
        animate.start();
    }

    /**
     * 初始化一些东西
     */
    private void init() {
        setSupportActionBar(toolbarInweb);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        FontDefault.setChecked(true);
        if (isSrceenPORTRAIT){
            Drawable top = getResources().getDrawable(R.drawable.ic_menu_send, null);
            rotate.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
        }else {
            Drawable top = getResources().getDrawable(R.drawable.ic_menu_manage, null);
            rotate.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
        }

    }

    /**
     * 判断左下角按钮按下以后应该出现蒙版的逻辑
     */
    private void decideMengBanShouldComing() {
        fab.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                fabToggleState = opened;
                if (opened) {
                    openMengBan();
                } else {
                    closeMengBan();
                }
            }
        });
    }

    /**
     * 关闭蒙版的动画
     */
    private void closeMengBan() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.7f, 0);
        alphaAnimation.setDuration(500);
        fabMengban.startAnimation(alphaAnimation);
        fabMengban.setVisibility(View.INVISIBLE);
    }

    /**
     * 打开蒙版的动画
     */
    private void openMengBan() {
        fabMengban.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 0.7f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        fabMengban.startAnimation(alphaAnimation);
    }

    @Override
    protected WebActivityPresent createPresenter() {
        return new WebActivityPresent(this);
    }

    /**
     * 每次进入这个activity调用这个（除了第一次，第一次是oncreate）
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //
        //Log.e("sout", "onNewIntent");
        //接收传进来的src和url
        src = intent.getStringExtra("src");
        url = intent.getStringExtra("url");
        //Log.e("sout", src + "--" + url);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //退出的时候关闭底部设置栏
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(settingView);
        animate.translationY(settingView.getHeight());
        animate.setDuration(10);
        animate.start();

        FontDefault.setChecked(true);
        FontSeekBar.setProgress(50);
        lightDefault.setChecked(true);
        light_seekBar.setProgress(50);
        activityBrightnessManager.setActivityBrightness(-1.0f, WebActivity.this);

        if (webView != null) {
            webView.onPause();
        }
//        src = null;
//        url = null;
        toolSrctext.setText("");
        Log.e("sout", src + "-onStop-" + url);
        webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        webView.clearHistory();
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (webParent != null) {
                    webParent.removeView(webView);
                }
                webView.removeAllViews();
                webView.destroy();
            } else {
                webView.removeAllViews();
                webView.destroy();
                if (webParent != null) {
                    webParent.removeView(webView);
                }
            }
            webView = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        progress.setProgress(0);
        progress.setVisibility(View.VISIBLE);
        webView = new WebView(this);
        //获得WebView的设置
        webSettings = webView.getSettings();
        webSettings.setAllowFileAccess(true);
        webSettings.setUseWideViewPort(true);// 设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);//适配
        webSettings.setJavaScriptEnabled(true);  //支持js
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);  //设置 缓存模式
        webSettings.setDomStorageEnabled(true);// 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true);//开启 database storage API 功能
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);//HTTPS，注意这个是在LOLLIPOP以上才调用的
        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
        webSettings.setBlockNetworkImage(true);//关闭加载网络图片，在一开始加载的时候可以设置为true，当加载完网页的时候再设置为false
        webSettings.setBuiltInZoomControls(true);
        webParent.addView(webView);

        if (webView != null) {
            webView.onResume();
            if (url != null) {
                webView.loadUrl(url);//WebView加载的网页使用loadUrl
                toolSrctext.setText(src);
            }
        }
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                // Log.e("sout", "" + newProgress);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    progress.setProgress(newProgress, true);
                } else {
                    progress.setProgress(newProgress);
                }
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progress.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                //加载出错了
                Toast.makeText(WebActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //加载完成
                progress.setVisibility(View.GONE);
                webSettings.setBlockNetworkImage(closeLoadImage);
                //  Log.e("sout", "GONE了");
                Toast.makeText(WebActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        });

        floatingParent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) {
                    if (fabToggleState) {
                        fab.toggle(false);
                    }
                    if (settingViewState) {
                        closeSettingView();
                        settingViewState = false;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("sout", "onDestroy");
        if (webView != null) {
            webView.clearCache(true); //清空缓存
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (webParent != null) {
                    webParent.removeView(webView);
                }
                webView.removeAllViews();
                webView.destroy();
            } else {
                webView.removeAllViews();
                webView.destroy();
                if (webParent != null) {
                    webParent.removeView(webView);
                }
            }
            webView = null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!fabToggleState) {
                if (webView.canGoBack()) {
                    webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                    webView.goBack();
                    return false;
                } else {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }
            } else {
                fab.toggle(false);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
