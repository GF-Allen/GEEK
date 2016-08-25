package com.alenbeyond.runoob.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

/**
 * Created by AlenBeyond on 2016/8/25.
 */
public class BitmapUtils {

    /**
     * 圆形
     *
     * @param context
     * @param bitmap
     * @return
     */
    public static Drawable createCircularDrawable(Context context, Bitmap bitmap) {
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        drawable.setCircular(true);
        return drawable;
    }

    /**
     * 圆角
     *
     * @param context
     * @param bitmap
     * @param radius
     * @return
     */
    public static Drawable createCornerDrawable(Context context, Bitmap bitmap, float radius) {
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        drawable.setCornerRadius(radius);
        return drawable;
    }

    /**
     * Drawable 转 Bitmap
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawable2bitmap(Drawable drawable) {
        BitmapDrawable bitmap = (BitmapDrawable) drawable;
        return bitmap.getBitmap();
    }

}
