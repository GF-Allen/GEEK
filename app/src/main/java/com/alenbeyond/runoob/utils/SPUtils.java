package com.alenbeyond.runoob.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alen on 2016/8/25.
 */
public class SPUtils {
    /**
     * SharedPreference
     */
    public static final String SPF_NAME = "config_geek";


    public static void putString(Context context, String key, String value) {
        getSharedPreference(context).edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        return getSharedPreference(context).getString(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        getSharedPreference(context).edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        return getSharedPreference(context).getInt(key, defValue);
    }

    private static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(SPF_NAME, Context.MODE_PRIVATE);
    }
}
