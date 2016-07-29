package com.alen.runoob.rx;

import com.alen.runoob.bean.Category;
import com.alen.runoob.bean.Chapter;
import com.alen.runoob.runoob.Runoob;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jeff on 2016/5/24.
 */
public class ApiManager {

    /**
     * 获取大类别
     *
     * @param subscribe
     */
    public static void getObCategory(Observer<List<Category>> subscribe) {
        Observable.fromCallable(new Callable<List<Category>>() {
            @Override
            public List<Category> call() throws Exception {
                return Runoob.getCategorys();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    /**
     * 获取小章节
     *
     * @param url
     * @param subscribe
     */
    public static void getObChapter(final String url, Observer<List<Chapter>> subscribe) {
        Observable.fromCallable(new Callable<List<Chapter>>() {
            @Override
            public List<Chapter> call() throws Exception {
                return Runoob.getChapter(url);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }
}
