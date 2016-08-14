package com.alen.runoob.rx;

import com.alen.runoob.crawler.Github;
import com.alen.runoob.greendao.bean.GithubCollect;
import com.alen.runoob.greendao.bean.RunoobCategory;
import com.alen.runoob.greendao.bean.RunoobChapter;
import com.alen.runoob.crawler.Runoob;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by AlenBeyond on 2016/5/24.
 */
public class ApiManager {

    /**
     * 获取大类别
     *
     * @param subscribe
     */
    public static void getObCategory(Observer<List<RunoobCategory>> subscribe) {
        Observable.fromCallable(new Callable<List<RunoobCategory>>() {
            @Override
            public List<RunoobCategory> call() throws Exception {
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
    public static void getObChapter(final String url, Observer<List<RunoobChapter>> subscribe) {
        Observable.fromCallable(new Callable<List<RunoobChapter>>() {
            @Override
            public List<RunoobChapter> call() throws Exception {
                return Runoob.getChapter(url);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    /**
     * 获取github上的内容
     *
     * @param subscribe
     */
    public static void getObGithub(Observer<List<GithubCollect>> subscribe) {
        Observable.fromCallable(new Callable<List<GithubCollect>>() {
            @Override
            public List<GithubCollect> call() throws Exception {
                return Github.getCollectMD();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }
}
