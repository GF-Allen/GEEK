package com.alen.runoob.activity;

import android.content.Intent;
import android.os.Handler;

import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initData() {
        super.initData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, CategoryActivity.class));
                finish();
            }
        }, 2000);
    }
}
