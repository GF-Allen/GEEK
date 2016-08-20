package com.alenbeyond.runoob.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.constant.WebType;
import com.alenbeyond.runoob.js.Js;
import com.alenbeyond.runoob.utils.ReflectUtils;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {

    private static final int HANDLER_FINISH = 0;
    private static final int HANDLER_TIMEOUT = 1;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ll_web_net_not_available)
    LinearLayout mNetNotAvailable;
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.progressBar_web)
    ProgressBar progressBarWeb;
    @BindView(R.id.tv_net_info)
    TextView tvNetInfo;

    private MyHandler mHandler;
    private String url;
    private String title;
    private int type;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        setStatusTranslucent();
        getIntentData();
        mHandler = new MyHandler(this);
        mToolbar.setTitle(title);
        mToolbar.setLogo(new ColorDrawable(Color.TRANSPARENT));
        try {
            ImageView mLogoView = (ImageView) ReflectUtils.getField(mToolbar, mToolbar.getClass().getName(), "mLogoView");
            mLogoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            ReflectUtils.setField(mToolbar, mToolbar.getClass().getName(), "mLogoView", mLogoView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mWebView.setWebChromeClient(new MyWebChromeClient());
        if (type == WebType.WEB_DETAIL) {
            mWebView.setWebViewClient(new DetailWebViewClient());
        }
        WebSettings setting = mWebView.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setDomStorageEnabled(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);

        mNetNotAvailable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    private void getIntentData() {
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        type = getIntent().getIntExtra("type", WebType.WEB_COMMON);
    }

    @Override
    protected void loadData() {
        mWebView.loadUrl(url);
        if (type == WebType.WEB_DETAIL) {
            mWebView.setVisibility(View.INVISIBLE);
            mHandler.sendEmptyMessageDelayed(HANDLER_TIMEOUT, 10 * 1000);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 在有上一页的时候返回上一页
     */
    @Override
    public void onBackPressed() {

        if (mWebView.canGoBack()) {
            mWebView.goBack();
            mToolbar.setLogo(R.mipmap.close);
            mToolbar.setTitle("  " + mToolbar.getTitle());
            if (type == WebType.WEB_DETAIL) {
                mWebView.setVisibility(View.INVISIBLE);
            }
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 自定义webView WebChromeClient处理事件
     */
    private class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                if (mWebView.getTitle() != null && type != WebType.WEB_DETAIL) {
                    mToolbar.setTitle(mWebView.getTitle());
                }
                progressBarWeb.setVisibility(View.GONE);
            } else {
                if (progressBarWeb.getVisibility() == View.GONE) {
                    progressBarWeb.setVisibility(View.VISIBLE);
                }
            }
            progressBarWeb.setProgress(newProgress);
            progressBarWeb.postInvalidate();
            super.onProgressChanged(view, newProgress);
        }
    }

    private class DetailWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("http://www.runoob.com/try/")) {
                view.loadUrl(url);
                mWebView.setVisibility(View.INVISIBLE);
            }
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            view.loadUrl(Js.getClass);
            view.loadUrl(Js.hideDiv);
            view.loadUrl(Js.hide);
            view.loadUrl("javascript:hide();");
            mHandler.sendEmptyMessageDelayed(HANDLER_FINISH, 500);
            super.onPageFinished(view, url);
        }
    }

    /**
     * 处理可能发生OOM的情况
     */
    private static class MyHandler extends Handler {

        WeakReference<WebActivity> weakReference;

        public MyHandler(WebActivity webActivity) {
            weakReference = new WeakReference<>(webActivity);
        }

        @Override
        public void handleMessage(Message msg) {

            WebActivity m = weakReference.get();

            switch (msg.what) {
                case HANDLER_FINISH:
                    m.mWebView.setVisibility(View.VISIBLE);
                    m.mNetNotAvailable.setVisibility(View.INVISIBLE);
                    removeCallbacksAndMessages(null);
                    break;
                case HANDLER_TIMEOUT:
                    m.tvNetInfo.setText("亲，网络有点慢哦，请耐心等待");
                    m.mNetNotAvailable.setVisibility(View.VISIBLE);
                    m.mWebView.setVisibility(View.GONE);
                    removeCallbacksAndMessages(null);
                    break;
            }
        }
    }
}
