package com.alen.runoob;

import android.app.Application;

import com.alen.runoob.greendao.gen.DaoMaster;

/**
 * Created by Jeff on 2016/8/4.
 */
public class App extends Application {

    public static DaoMaster daoMaster;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "runoob.db", null);
        daoMaster = new DaoMaster(helper.getWritableDb());
    }
}
