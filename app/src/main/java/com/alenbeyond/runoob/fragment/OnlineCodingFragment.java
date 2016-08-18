package com.alenbeyond.runoob.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.constant.Constants;
import com.alenbeyond.runoob.fragment.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Alen on 2016/8/16.
 */
public class OnlineCodingFragment extends BaseFragment {

    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.ll_web_net_not_available)
    LinearLayout mNetNotAvailable;
    @BindView(R.id.tv_net_info)
    TextView tvNetInfo;
    @BindView(R.id.progressBar_web)
    ProgressBar mProgressBar;

    private Handler mHandler;

    @Override
    protected View setContentView() {
        return View.inflate(getContext(), R.layout.fragment_online_coding, null);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void initView() {

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        Snackbar.make(mWebView, "网络不稳定", Snackbar.LENGTH_LONG).setAction("重试", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                initData();
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();
                        break;
                }
            }
        };

        mWebView.setWebChromeClient(new MyWebChromeClient());
        mWebView.requestFocus(View.FOCUS_DOWN);
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

    @Override
    protected void loadData() {
        mWebView.loadUrl(Constants.URL_ONLINE_CODING);
        mHandler.sendEmptyMessageDelayed(0, 5 * 1000);
    }

    /**
     * 自定义webView WebChromeClient处理事件
     */
    private class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setVisibility(View.GONE);
            } else {
                if (mProgressBar.getVisibility() == View.GONE) {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
            }
            mProgressBar.setProgress(newProgress);
            mProgressBar.postInvalidate();
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
    }
}
