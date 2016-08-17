package com.alenbeyond.runoob;

import android.app.Application;

import com.alenbeyond.runoob.greendao.gen.DaoMaster;
import com.lzy.okhttputils.OkHttpUtils;
import com.orhanobut.logger.Logger;

/**
 * Created by Jeff on 2016/8/4.
 */
public class App extends Application {

    private static final String TAG = "Geek";
    public static DaoMaster daoMaster;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "runoob.db", null);
        daoMaster = new DaoMaster(helper.getWritableDb());
    }

    private void init() {
        OkHttpUtils.init(this);
        Logger.init(TAG);
    }
}
