package com.alen.runoob.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;

import com.alen.runoob.App;
import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;
import com.alen.runoob.greendao.bean.GithubCollect;
import com.alen.runoob.greendao.bean.RunoobCategory;
import com.alen.runoob.greendao.bean.RunoobItem;
import com.alen.runoob.greendao.gen.RunoobCategoryDao;
import com.alen.runoob.greendao.gen.DaoSession;
import com.alen.runoob.greendao.gen.RunoobItemDao;
import com.alen.runoob.rx.ApiManager;
import com.alen.runoob.rx.MyObserver;
import com.hanks.htextview.HTextView;
import com.orhanobut.logger.Logger;

import java.util.List;

public class SplashActivity extends BaseActivity {

    private HTextView text;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_splash);
        text = findView(R.id.text);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        text.animateText("爱生活，爱编程");
    }

    @Override
    protected void loadServer() {
        long startTime = SystemClock.currentThreadTimeMillis();

        Logger.d("测试");

        ApiManager.getObGithub(new MyObserver<List<GithubCollect>>() {
            @Override
            public void onNext(List<GithubCollect> datas) {
                Logger.d(datas);
            }
        });

        saveCache();

        long endTime = SystemClock.currentThreadTimeMillis();
        long d = endTime - startTime;

        if (d > 2000) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }, 2000 - d);
        }
    }

    /**
     * 缓存数据
     */
    private void saveCache() {
        final DaoSession daoSession = App.daoMaster.newSession();
        final RunoobItemDao itemDao = daoSession.getRunoobItemDao();
        final RunoobCategoryDao categoryDao = daoSession.getRunoobCategoryDao();
        if (categoryDao.queryBuilder().list().size() != 0) {
            return;
        }

        ApiManager.getObCategory(new MyObserver<List<RunoobCategory>>() {
            @Override
            public void onNext(List<RunoobCategory> categories) {
                categoryDao.insertInTx(categories);
                for (RunoobCategory categroy : categories) {
                    for (RunoobItem runoobItem : categroy.getRunoobItem()) {
                        runoobItem.setCategroyId(categroy.getId());
                        itemDao.insert(runoobItem);
                    }
                }
            }
        });
    }
}
