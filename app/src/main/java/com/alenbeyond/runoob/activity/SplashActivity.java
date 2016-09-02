package com.alenbeyond.runoob.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.BuildConfig;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.greendao.bean.AnyCodesPDF;
import com.alenbeyond.runoob.greendao.bean.GithubCollect;
import com.alenbeyond.runoob.greendao.bean.RNApiGroup;
import com.alenbeyond.runoob.greendao.bean.RNApiSub;
import com.alenbeyond.runoob.greendao.bean.RunoobCategory;
import com.alenbeyond.runoob.greendao.bean.RunoobItem;
import com.alenbeyond.runoob.greendao.gen.AllOperatorsDao;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.greendao.gen.RNApiGroupDao;
import com.alenbeyond.runoob.greendao.gen.RunoobCategoryDao;
import com.alenbeyond.runoob.greendao.gen.RunoobItemDao;
import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;
import com.alenbeyond.runoob.rx.ApiManager;
import com.alenbeyond.runoob.rx.MyObserver;
import com.alenbeyond.runoob.utils.UiUtils;
import com.hanks.htextview.HTextView;
import com.orhanobut.logger.Logger;

import java.util.List;

public class SplashActivity extends BaseActivity {

    public static final int TIME_OUT = 3 * 1000;

    private HTextView text;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_splash);
        text = findView(R.id.text);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        text.animateText("爱生活，爱编程");
        if (BuildConfig.DEBUG) {
            UiUtils.showToast(this, "测试版");
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    startActivity(new Intent(SplashActivity.this, TestActivity.class));
//                    ApiManager.getObAnycodesPdf(new MyObserver<List<AnyCodesPDF>>() {
//                        @Override
//                        public void onNext(List<AnyCodesPDF> anyCodesPDFs) {
//                            Logger.d("size:" + anyCodesPDFs.size());
//                            Logger.d(anyCodesPDFs);
//                        }
//                    });
                }
            });
        }
    }

    @Override
    public void initData() {
        long startTime = SystemClock.currentThreadTimeMillis();

//        ApiManager.getObGithub(new MyObserver<List<GithubCollect>>() {
//            @Override
//            public void onNext(List<GithubCollect> datas) {
//                Logger.d(datas);
//            }
//        });

        saveCache();

        long endTime = SystemClock.currentThreadTimeMillis();
        long d = endTime - startTime;

        if (d > TIME_OUT) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, TIME_OUT - d);
        }
    }

    /**
     * 缓存数据
     */
    private void saveCache() {
        final DaoSession daoSession = App.daoMaster.newSession();
        final RunoobItemDao itemDao = daoSession.getRunoobItemDao();
        final RunoobCategoryDao categoryDao = daoSession.getRunoobCategoryDao();
        final AllOperatorsDao operatorsDao = daoSession.getAllOperatorsDao();
        final RNApiGroupDao rnApiGroupDao = daoSession.getRNApiGroupDao();

        if (categoryDao.queryBuilder().list().size() == 0) {
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

        if (operatorsDao.queryBuilder().list().size() == 0) {
            ApiManager.getObRxJavaAll(new MyObserver<List<AllOperators>>() {
                @Override
                public void onNext(List<AllOperators> allOperatorses) {
                    operatorsDao.insertInTx(allOperatorses);
                }
            });
        }

        if (rnApiGroupDao.queryBuilder().list().size() == 0) {
            ApiManager.getObRNApiGroup(new MyObserver<List<RNApiGroup>>() {
                @Override
                public void onNext(List<RNApiGroup> rnApiGroups) {
                    rnApiGroupDao.insertInTx(rnApiGroups);
                }
            });
        }

    }
}
