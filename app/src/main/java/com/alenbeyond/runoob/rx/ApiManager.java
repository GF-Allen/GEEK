package com.alenbeyond.runoob.rx;

import com.alenbeyond.runoob.crawler.Anycodes;
import com.alenbeyond.runoob.crawler.Github;
import com.alenbeyond.runoob.crawler.ReactNative;
import com.alenbeyond.runoob.greendao.bean.AnyCodesPDF;
import com.alenbeyond.runoob.greendao.bean.GithubCollect;
import com.alenbeyond.runoob.greendao.bean.RNApiGroup;
import com.alenbeyond.runoob.greendao.bean.RNApiSub;
import com.alenbeyond.runoob.greendao.bean.RunoobCategory;
import com.alenbeyond.runoob.greendao.bean.RunoobChapter;
import com.alenbeyond.runoob.crawler.Runoob;
import com.alenbeyond.runoob.resource.pdf.bean.PdfResource;
import com.alenbeyond.runoob.resource.pdf.data.PdfResourceUtils;
import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;
import com.alenbeyond.runoob.resource.rxjava.bean.Operators;
import com.alenbeyond.runoob.resource.rxjava.data.RxJavaDataUtils;

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

    public static void getObAnycodesPdf(Observer<List<AnyCodesPDF>> subscribe) {
        Observable.fromCallable(new Callable<List<AnyCodesPDF>>() {
            @Override
            public List<AnyCodesPDF> call() throws Exception {
                return Anycodes.getPDFResource("http://study.anycodes.cn/index.php?mod=folder&sid=18oOe3", 1);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    public static void getObRxJavaAll(Observer<List<AllOperators>> subscribe) {
        Observable.fromCallable(new Callable<List<AllOperators>>() {
            @Override
            public List<AllOperators> call() throws Exception {
                return RxJavaDataUtils.getAllOperators();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    public static void getObRxOperators(Observer<List<Operators>> subscribe) {
        Observable.fromCallable(new Callable<List<Operators>>() {
            @Override
            public List<Operators> call() throws Exception {
                return RxJavaDataUtils.getOperators();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    public static void getObPdfResources(Observer<List<PdfResource>> subscribe) {
        Observable.fromCallable(new Callable<List<PdfResource>>() {
            @Override
            public List<PdfResource> call() throws Exception {
                return PdfResourceUtils.getPdfData();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    /**
     * ReactNative获取分组
     *
     * @param subscribe
     */
    public static void getObRNApiGroup(Observer<List<RNApiGroup>> subscribe) {
        Observable.fromCallable(new Callable<List<RNApiGroup>>() {
            @Override
            public List<RNApiGroup> call() throws Exception {
                return ReactNative.getApiGroup();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }

    /**
     * ReactNative根据分组获取小分类
     *
     * @param groupId
     * @param subscribe
     */
    public static void getObRNApiSub(final int groupId, Observer<List<RNApiSub>> subscribe) {
        Observable.fromCallable(new Callable<List<RNApiSub>>() {
            @Override
            public List<RNApiSub> call() throws Exception {
                return ReactNative.getApiSub(groupId + "");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }


}
