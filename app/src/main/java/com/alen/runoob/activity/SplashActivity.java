package com.alen.runoob.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import com.alen.runoob.App;
import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;
import com.alen.runoob.greendao.bean.Category;
import com.alen.runoob.greendao.bean.Item;
import com.alen.runoob.greendao.gen.CategoryDao;
import com.alen.runoob.greendao.gen.DaoSession;
import com.alen.runoob.greendao.gen.ItemDao;
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
        text.animateText("爱生活，爱编程");
    }

    @Override
    protected void loadServer() {
        long startTime = SystemClock.currentThreadTimeMillis();

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
        final ItemDao itemDao = daoSession.getItemDao();
        final CategoryDao categoryDao = daoSession.getCategoryDao();
        if (categoryDao.queryBuilder().list().size() != 0) {
            return;
        }

        ApiManager.getObCategory(new MyObserver<List<Category>>() {
            @Override
            public void onNext(List<Category> categories) {
                categoryDao.insertInTx(categories);
                for (Category categroy : categories) {
                    for (Item item : categroy.getItem()) {
                        item.setCategroyId(categroy.getId());
                        itemDao.insert(item);
                    }
                }
            }
        });
    }
}
