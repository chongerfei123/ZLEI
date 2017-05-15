package com.example.zl.zlei.View.activi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zl.zlei.Present.WebActivityPresent;
import com.example.zl.zlei.R;
import com.example.zl.zlei.View.MainActivity;
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
    private WebView webView;
    private String src = null;
    private String url = null;
    private WebSettings webSettings;
    private boolean fabToggleState;
    private boolean settingViewState = true;
    private boolean settingViewopenFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        init();
        settingView.setVisibility(View.INVISIBLE);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (settingViewopenFirst){
                    settingView.setVisibility(View.VISIBLE);
                    settingViewopenFirst = false;
                }else {
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


    private void openSettingView() {
//        settingView
        Log.e("sout","openSettingView");
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(settingView);
        animate.translationY(0);
        animate.setDuration(300);
        AccelerateInterpolator interpolator = new AccelerateInterpolator(2f);
        animate.setInterpolator(interpolator);
        animate.start();
    }

    private void closeSettingView() {
        Log.e("sout","closeSettingView");
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(settingView);
        animate.translationY(settingView.getHeight());
        animate.setDuration(300);
        AccelerateInterpolator interpolator = new AccelerateInterpolator(2f);
        animate.setInterpolator(interpolator);
        animate.start();
    }

    private void init() {
        setSupportActionBar(toolbarInweb);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

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

    private void closeMengBan() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.7f, 0);
        alphaAnimation.setDuration(500);
        fabMengban.startAnimation(alphaAnimation);
        fabMengban.setVisibility(View.INVISIBLE);
    }

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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //
        Log.e("sout", "onNewIntent");
        src = intent.getStringExtra("src");
        url = intent.getStringExtra("url");
        Log.e("sout", src + "--" + url);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
        src = null;
        url = null;
        toolSrctext.setText("");
        Log.e("sout", src + "-onPause-" + url);
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
    protected void onResume() {
        super.onResume();
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
                webSettings.setBlockNetworkImage(false);
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
                    if (settingViewState){
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
