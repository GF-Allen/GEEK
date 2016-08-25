package com.alenbeyond.runoob;

import android.app.Application;
import android.content.SharedPreferences;

import com.alenbeyond.runoob.constant.Constants;
import com.alenbeyond.runoob.greendao.gen.DaoMaster;
import com.alenbeyond.runoob.utils.AppUtils;
import com.alenbeyond.runoob.utils.SPUtils;
import com.lzy.okhttputils.OkHttpUtils;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.generator.Schema;

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
    }

    private void init() {
        OkHttpUtils.init(this);
        Logger.init(TAG);
        int version = SPUtils.getInt(this, "app_version", -1);
        if (version != -1 || version != AppUtils.getVerCode(this)) {
            SPUtils.putInt(this, "app_version", AppUtils.getVerCode(this));
            deleteDatabase(Constants.DB_NAME);
        }

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME, null);
        daoMaster = new DaoMaster(helper.getWritableDb());
    }
}
