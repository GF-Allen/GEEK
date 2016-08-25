package com.alenbeyond.runoob.resource.rxjava.data;

import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;
import com.alenbeyond.runoob.resource.rxjava.bean.Operators;

import java.util.ArrayList;
import java.util.List;

public class RxJavaDataUtils {

    private static long i = 1L;
    private static long parentId = 1L;

    private static final String IMMEDIATE = "immediate";
    private static final String COMPUTATION = "computation";
    private static final String DEFAULT = "默认线程";
    private static final String TRAMPOLINE = "trampoline";

    public static List<Operators> getOperators() {
        List<Operators> lists = new ArrayList<>();
        lists.add(new Operators(1L, "RxJava 介绍", 1L));
        lists.add(new Operators(2L, "创建操作", 2L));
        lists.add(new Operators(3L, "变换操作", 3L));
        lists.add(new Operators(4L, "过滤操作", 4L));
        lists.add(new Operators(5L, "结合操作", 5L));
        lists.add(new Operators(6L, "错误处理", 6L));
        lists.add(new Operators(7L, "辅助操作", 7L));
        lists.add(new Operators(8L, "条件和布尔操作", 8L));
        lists.add(new Operators(9L, "算术和聚合操作", 9L));
        lists.add(new Operators(10L, "异步操作", 10L));
        lists.add(new Operators(11L, "连接操作", 11L));
        lists.add(new Operators(12L, "阻塞操作", 12L));
        lists.add(new Operators(13L, "字符串操作", 13L));
        lists.add(new Operators(14L, "其他的相关操作", 14L));
        return lists;
    }

    public static List<AllOperators> getAllOperators() {
        List<AllOperators> allOperatorses = new ArrayList<>();
        getIntroduceList(allOperatorses);
        getCreatingList(allOperatorses);
        getTransformList(allOperatorses);
        getFilterList(allOperatorses);
        getCombinList(allOperatorses);
        getErrorList(allOperatorses);
        getUtilityList(allOperatorses);
        getConditionalList(allOperatorses);
        getMathList(allOperatorses);
        getSayncList(allOperatorses);
        getConnectList(allOperatorses);
        getBlockList(allOperatorses);
        getStringList(allOperatorses);
        getOthersList(allOperatorses);
        return allOperatorses;
    }


    private static void getOthersList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "实现自己的操作符", " ", "实现自己的操作符", CommonString.SPLASH_INDEX_URL, OperatorsUrl.OWN_OPERATE, parentId));
        alloperatorses.add(new AllOperators(i++, "自定义插件", " ", "自定义插件", CommonString.SPLASH_INDEX_URL, OperatorsUrl.OWN_CHAJIAN, parentId));
        alloperatorses.add(new AllOperators(i++, "Android模块", " ", "Android模块", CommonString.SPLASH_INDEX_URL, OperatorsUrl.ANDROID_MODULE, parentId));
        alloperatorses.add(new AllOperators(i++, "错误处理", " ", "错误处理", CommonString.SPLASH_INDEX_URL, OperatorsUrl.ERROR_HANDLE, parentId));

        parentId++;
    }


    private static void getStringList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "byLine()", DEFAULT, "将一个字符串的Observable转换为一个行序列的Observable，这个Observable将原来的序列当做流处理，然后按换行符分割", CommonString.byLine, OperatorsUrl.byLine, parentId));
        alloperatorses.add(new AllOperators(i++, "decode()", DEFAULT, "将一个多字节的字符流转换为一个Observable，它按字符边界发射字节数组", CommonString.decode, OperatorsUrl.decode, parentId));
        alloperatorses.add(new AllOperators(i++, "encode()", DEFAULT, "对一个发射字符串的Observable执行变换操作，变换后的Observable发射一个在原始字符串中表示多字节字符边界的字节数组", CommonString.encode, OperatorsUrl.encode, parentId));
        alloperatorses.add(new AllOperators(i++, "from()", DEFAULT, "将一个字符流或者Reader转换为一个发射字节数组或者字符串的Observable", CommonString.from_String, OperatorsUrl.from_String, parentId));
        alloperatorses.add(new AllOperators(i++, "join()", DEFAULT, "将一个发射字符串序列的Observable转换为一个发射单个字符串的Observable，后者用一个指定的字符串连接所有的字符串", CommonString.join, OperatorsUrl.join, parentId));
        alloperatorses.add(new AllOperators(i++, "split()", DEFAULT, "将一个发射字符串的Observable转换为另一个发射字符串的Observable，后者使用一个指定的正则表达式边界分割前者发射的所有字符串", CommonString.split, OperatorsUrl.split, parentId));
        alloperatorses.add(new AllOperators(i++, "stringConcat()", DEFAULT, "将一个发射字符串序列的Observable转换为一个发射单个字符串的Observable，后者连接前者发射的所有字符串", CommonString.stringConcat, OperatorsUrl.stringConcat, parentId));
        parentId++;
    }


    private static void getBlockList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "forEach()", DEFAULT, "对Observable发射的每一项数据调用一个方法，会阻塞直到Observable完成", CommonString.forEach, OperatorsUrl.forEach, parentId));
        alloperatorses.add(new AllOperators(i++, "first()", DEFAULT, "阻塞直到Observable发射了一个数据，然后返回第一项数据", CommonString.first, OperatorsUrl.first, parentId));
        alloperatorses.add(new AllOperators(i++, "firstOrDefault()", DEFAULT, "阻塞直到Observable发射了一个数据或者终止，返回第一项数据，或者返回默认值", CommonString.firstOrDefault, OperatorsUrl.firstOrDefault, parentId));
        alloperatorses.add(new AllOperators(i++, "last()", DEFAULT, "阻塞直到Observable终止，然后返回最后一项数据", CommonString.last, OperatorsUrl.last, parentId));
        alloperatorses.add(new AllOperators(i++, "lastOrDefault()", DEFAULT, "阻塞直到Observable终止，然后返回最后一项的数据，或者返回默认值()", CommonString.lastOrDefault, OperatorsUrl.lastOrDefault, parentId));
        alloperatorses.add(new AllOperators(i++, "mostRecent()", DEFAULT, "返回一个总是返回Observable最近发射的数据的iterable", CommonString.mostRecent, OperatorsUrl.mostRecent, parentId));
        alloperatorses.add(new AllOperators(i++, "next()", DEFAULT, "返回一个Iterable，会阻塞直到Observable发射了另一个值，然后返回那个值", CommonString.next, OperatorsUrl.next, parentId));
        alloperatorses.add(new AllOperators(i++, "single()", DEFAULT, " 如果Observable终止时只发射了一个值，返回那个值，否则抛出异常", CommonString.single, OperatorsUrl.single, parentId));
        alloperatorses.add(new AllOperators(i++, "singleOrDefault()", DEFAULT, "如果Observable终止时只发射了一个值，返回那个值，否则否好默认值", CommonString.singleOrDefault, OperatorsUrl.singleOrDefault, parentId));
        alloperatorses.add(new AllOperators(i++, "toFuture()", DEFAULT, "将Observable转换为一个Future", CommonString.toFuture, OperatorsUrl.toFuture, parentId));
        alloperatorses.add(new AllOperators(i++, "toIterable()", DEFAULT, "将一个发射数据序列的Observable转换为一个Iterable", CommonString.toIterable, OperatorsUrl.toIterable, parentId));
        alloperatorses.add(new AllOperators(i++, "getIterator()", DEFAULT, " 将一个发射数据序列的Observable转换为一个Iterator", CommonString.getIterator, OperatorsUrl.getIterator, parentId));

        parentId++;
    }

    private static void getConnectList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "connect()", DEFAULT, "指示一个可连接的Observable开始发射数据", CommonString.connect, OperatorsUrl.connect, parentId));
        alloperatorses.add(new AllOperators(i++, "publish()", DEFAULT, "将一个Observable转换为一个可连接的Observable", CommonString.publish, OperatorsUrl.publish, parentId));
        alloperatorses.add(new AllOperators(i++, "replay()", DEFAULT, "确保所有的订阅者看到相同的数据序列，即使它们在Observable开始发射数据之后才订阅", CommonString.replay, OperatorsUrl.replay, parentId));
        alloperatorses.add(new AllOperators(i++, "refCount()", DEFAULT, "让一个可连接的Observable表现得像一个普通的Observable", CommonString.refCount, OperatorsUrl.refCount, parentId));
        parentId++;
    }


    private static void getSayncList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "start()", DEFAULT, "创建一个Observable，它发射一个函数的返回值", CommonString.start, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "toAsync() or asyncAction() or asyncFunc()", DEFAULT, " 将一个函数或者Action转换为已Observable，它执行这个函数并发射函数的返回值", CommonString.toAsync, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "startFuture()", DEFAULT, "将一个返回Future的函数转换为一个Observable，它发射Future的返回值", CommonString.startFuture, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "deferFuture()", DEFAULT, "将一个返回Observable的Future转换为一个Observable，但是并不尝试获取这个Future返回的Observable，直到有订阅者订阅它", CommonString.deferFuture, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "forEachFuture()", DEFAULT, "传递Subscriber方法给一个Subscriber，但是同时表现得像一个Future一样阻塞直到它完成", CommonString.forEachFuture, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "fromAction()", DEFAULT, "将一个Action转换为Observable，当一个订阅者订阅时，它执行这个action并发射它的返回值", CommonString.fromAction, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "fromCallable()", DEFAULT, "将一个Callable转换为Observable，当一个订阅者订阅时，它执行这个Callable并发射Callable的返回值，或者发射异常", CommonString.fromCallable, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "fromRunnable()", DEFAULT, "convert a Runnable into an Observable that invokes the runable and emits its result when a Subscriber subscribes将一个Runnable转换为Observable，当一个订阅者订阅时，它执行这个Runnable并发射Runnable的返回值", CommonString.fromRunnable, OperatorsUrl.start, parentId));
        alloperatorses.add(new AllOperators(i++, "runAsync()", DEFAULT, "返回一个StoppableObservable，它发射某个Scheduler上指定的Action生成的多个actions", CommonString.runAsync, OperatorsUrl.start, parentId));
        parentId++;
    }

    private static void getMathList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "rxjava-math模块", " ", "模块的操作符", CommonString.MATH, OperatorsUrl.MATH, parentId));
        alloperatorses.add(new AllOperators(i++, "concat()", DEFAULT, "顺序连接多个Observables", CommonString.concat, OperatorsUrl.concat, parentId));
        alloperatorses.add(new AllOperators(i++, "count() and countLong()", DEFAULT, "计算数据项的个数并发射结果", CommonString.count, OperatorsUrl.count, parentId));
        alloperatorses.add(new AllOperators(i++, "reduce()", DEFAULT, "对序列使用reduce()函数并发射对吼的结果", CommonString.reduce, OperatorsUrl.reduce, parentId));
        alloperatorses.add(new AllOperators(i++, "collect()", DEFAULT, "将原始Observable发射的数据放到一个单一的可变的数据结构中，然后返回一个发射这个数据结构的Observable", CommonString.collect, OperatorsUrl.collect, parentId));
        alloperatorses.add(new AllOperators(i++, "toList()", DEFAULT, "收集原始Observable发射的所有数据到一个列表，然后返回这个列表", CommonString.toList, OperatorsUrl.toList, parentId));
        alloperatorses.add(new AllOperators(i++, "toSortedList()", DEFAULT, "收集原始Observable发射的所有数据到一个有序列表，然后返回这个列表", CommonString.toSortedList, OperatorsUrl.toSortedList, parentId));
        alloperatorses.add(new AllOperators(i++, "toMap()", DEFAULT, "将序列数据转换为一个Map，Map的key是根据一个函数计算的", CommonString.toMap, OperatorsUrl.toMap, parentId));
        alloperatorses.add(new AllOperators(i++, "toMultiMap()", DEFAULT, "将序列数据转换为一个列表，同时也是一个Map，Map的key是根据一个函数计算的", CommonString.toMultiMap, OperatorsUrl.toMultiMap, parentId));
        parentId++;
    }

    private static void getConditionalList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "amb()", DEFAULT, "给定多个Observable，只让第一个发射数据的Observable发射全部数据", CommonString.amb, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "defaultIfEmpty()", DEFAULT, "发射来自原始Observable的数据，如果原始Observable没有发射数据，就发射一个默认数据", CommonString.defaultIfEmpty, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "doWhile()", DEFAULT, "发射原始Observable的数据序列，然后重复发射这个序列直到不满足这个条件为止", CommonString.doWhile, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "ifThen()", DEFAULT, "只有当某个条件为真时才发射原始Observable的数据序列，否则发射一个空的或默认的序列", CommonString.ifThen, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "skipUntil()", DEFAULT, "丢弃原始Observable发射的数据，直到第二个Observable发射了一个数据，然后发射原始Observable的剩余数据", CommonString.skipUntil, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "skipWhile()", DEFAULT, "丢弃原始Observable发射的数据，直到一个特定的条件为假，然后发射原始Observable剩余的数据", CommonString.skipWhile, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "switchCase()", DEFAULT, "基于一个计算结果，发射一个指定Observable的数据序列", CommonString.switchCase, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "takeUntil()", DEFAULT, "发射来自原始Observable的数据，直到第二个Observable发射了一个数据或一个通知", CommonString.takeUntil, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "takeWhile(),takeWhileWithIndex()", DEFAULT, "射原始Observable的数据，直到一个特定的条件为真，然后跳过剩余的数据", CommonString.takeWhile, OperatorsUrl.amb, parentId));
        alloperatorses.add(new AllOperators(i++, "whileDo()", DEFAULT, "if a condition is true, emit the source Observable's sequence and then repeat the sequence as long as the condition remains true如果满足一个条件，发射原始Observable的数据，然后重复发射直到不满足这个条件为止", CommonString.takeWhile, CommonString.GITHUB_URL, parentId));

        alloperatorses.add(new AllOperators(i++, "all()", DEFAULT, "判断是否所有的数据项都满足某个条件", CommonString.all, OperatorsUrl.BOOLEAN_ALL, parentId));
        alloperatorses.add(new AllOperators(i++, "contains()", DEFAULT, "判断Observable是否会发射一个指定的值", CommonString.contains, OperatorsUrl.BOOLEAN_ALL, parentId));
        alloperatorses.add(new AllOperators(i++, "exists(),isEmpty()", DEFAULT, "判断Observable是否发射了一个值", CommonString.exists, OperatorsUrl.BOOLEAN_ALL, parentId));
        alloperatorses.add(new AllOperators(i++, "sequenceEqual()", DEFAULT, " test the equality of the sequences emitted by two Observables判断两个Observables发射的序列是否相等", CommonString.sequenceEqual, OperatorsUrl.BOOLEAN_ALL, parentId));
        parentId++;

    }


    private static void getUtilityList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "Materialize()", DEFAULT, "将Observable转换成一个通知列表convert an Observable into a list of Notifications", CommonString.Materialize, OperatorsUrl.Materialize, parentId));
        alloperatorses.add(new AllOperators(i++, "Dematerialize()", DEFAULT, "将上面的结果逆转回一个Observable", CommonString.Dematerialize, OperatorsUrl.Dematerialize, parentId));
        alloperatorses.add(new AllOperators(i++, "Timestamp()", IMMEDIATE, "给Observable发射的每个数据项添加一个时间戳", CommonString.Timestamp, OperatorsUrl.Timestamp, parentId));
        alloperatorses.add(new AllOperators(i++, "Serialize()", DEFAULT, "强制Observable按次序发射数据并且要求功能是完好的", CommonString.Serialize, OperatorsUrl.Serialize, parentId));
        alloperatorses.add(new AllOperators(i++, "ObserveOn()", " ", "指定观察者观察Observable的调度器", CommonString.ObserveOn, OperatorsUrl.ObserveOn, parentId));
        alloperatorses.add(new AllOperators(i++, "SubscribeOn()", " ", "指定Observable执行任务的调度器", CommonString.SubscribeOn, OperatorsUrl.SubscribeOn, parentId));
        alloperatorses.add(new AllOperators(i++, "doOnEach()", DEFAULT, "注册一个动作，对Observable发射的每个数据项使用", CommonString.doOnEach, OperatorsUrl.doOnEach, parentId));
        alloperatorses.add(new AllOperators(i++, "doOnSubscribe()", DEFAULT, "注册一个动作，在观察者订阅时使用", CommonString.doOnSubscribe, OperatorsUrl.doOnSubscribe, parentId));
        alloperatorses.add(new AllOperators(i++, "doOnUnsubscribe()", DEFAULT, "注册一个动作，在观察者取消订阅时使用", CommonString.doOnUnsubscribe, OperatorsUrl.doOnUnsubscribe, parentId));
        alloperatorses.add(new AllOperators(i++, "doOnCompleted()", DEFAULT, "注册一个动作，对正常完成的Observable使用", CommonString.doOnCompleted, OperatorsUrl.doOnCompleted, parentId));
        alloperatorses.add(new AllOperators(i++, "doOnError()", DEFAULT, "注册一个动作，对Observable发射的每个数据项使用", CommonString.doOnError, OperatorsUrl.doOnError, parentId));
        alloperatorses.add(new AllOperators(i++, "doOnTerminate()", DEFAULT, "注册一个动作，对完成的Observable使用，无论是否发生错误", CommonString.doOnTerminate, OperatorsUrl.doOnTerminate, parentId));
        alloperatorses.add(new AllOperators(i++, "finallyDo()", DEFAULT, "注册一个动作，在Observable完成时使用", CommonString.finallyDo, OperatorsUrl.finallyDo, parentId));
        alloperatorses.add(new AllOperators(i++, "Delay()", DEFAULT, "延时发射Observable的结果", CommonString.Delay, OperatorsUrl.Delay, parentId));
        alloperatorses.add(new AllOperators(i++, "delaySubscription()", DEFAULT, "延时处理订阅请求", CommonString.delaySubscription, OperatorsUrl.delaySubscription, parentId));
        alloperatorses.add(new AllOperators(i++, "TimeInterval()", DEFAULT, "定期发射数据", CommonString.TimeInterval, OperatorsUrl.TimeInterval, parentId));
        alloperatorses.add(new AllOperators(i++, "Using()", DEFAULT, " 创建一个只在Observable生命周期存在的资源", CommonString.Using, OperatorsUrl.Using, parentId));
        alloperatorses.add(new AllOperators(i++, "single()", DEFAULT, " 强制返回单个数据，否则抛出异常", CommonString.First, OperatorsUrl.First, parentId));
        alloperatorses.add(new AllOperators(i++, "toFuture(), toIterable(), toList()", DEFAULT, "将Observable转换为其它对象或数据结构,只能用于BlockingObservable", CommonString.To, OperatorsUrl.To, parentId));
        parentId++;
    }


    private static void getErrorList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "onErrorResumeNext()", DEFAULT, "指示Observable在遇到错误时发射一个数据序列", CommonString.EMPTY, OperatorsUrl.ERROR, parentId));
        alloperatorses.add(new AllOperators(i++, "onErrorReturn()", DEFAULT, "指示Observable在遇到错误时发射一个特定的数据", CommonString.EMPTY, OperatorsUrl.ERROR, parentId));
        alloperatorses.add(new AllOperators(i++, "onExceptionResumeNext()", DEFAULT, "instructs an Observable to continue emitting items after it encounters an exception (but not another variety of throwable)指示Observable遇到错误时继续发射数据", CommonString.EMPTY, OperatorsUrl.ERROR, parentId));
        alloperatorses.add(new AllOperators(i++, "retry()", DEFAULT, "指示Observable遇到错误时重试", CommonString.RETRY, OperatorsUrl.RETRY, parentId));
        alloperatorses.add(new AllOperators(i++, "retryWhen()", DEFAULT, "指示Observable遇到错误时，将错误传递给另一个Observable来决定是否要重新给订阅这个Observable", CommonString.RETRYWHEN, OperatorsUrl.RETRY, parentId));
        parentId++;
    }


    private static void getCombinList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "startWith()", DEFAULT, "在数据序列的开头增加一项数据", CommonString.STARTWITH, OperatorsUrl.STARTWITH, parentId));
        alloperatorses.add(new AllOperators(i++, "merge()", DEFAULT, "将多个Observable合并为一个", CommonString.MERGE, OperatorsUrl.MERGE, parentId));
        alloperatorses.add(new AllOperators(i++, "mergeDelayError()", DEFAULT, "合并多个Observables，让没有错误的Observable都完成后再发射错误通知", CommonString.MERGEDELAY, OperatorsUrl.MERGEDELAY, parentId));
        alloperatorses.add(new AllOperators(i++, "zip()", DEFAULT, "使用一个函数组合多个Observable发射的数据集合，然后再发射这个结果", CommonString.ZIP, OperatorsUrl.ZIP, parentId));
        alloperatorses.add(new AllOperators(i++, "and(), then(), and when()", DEFAULT, "(rxjava-joins)通过模式和计划组合多个Observables发射的数据集合", CommonString.AND, OperatorsUrl.AND, parentId));
        alloperatorses.add(new AllOperators(i++, "combineLatest()", DEFAULT, "当两个Observables中的任何一个发射了一个数据时，通过一个指定的函数组合每个Observable发射的最新数据（一共两个数据），然后发射这个函数的结果", CommonString.COMBINLASTED, OperatorsUrl.COMBINLASTED, parentId));
        alloperatorses.add(new AllOperators(i++, "join() and groupJoin()", DEFAULT, "无论何时，如果一个Observable发射了一个数据项，只要在另一个Observable发射的数据项定义的时间窗口内，就将两个Observable发射的数据合并发射", CommonString.JOIN, OperatorsUrl.JOIN, parentId));
        alloperatorses.add(new AllOperators(i++, "switchOnNext()", DEFAULT, "将一个发射Observables的Observable转换成另一个Observable，后者发射这些Observables最近发射的数据", CommonString.SWITHONNEXT, OperatorsUrl.SWITHONNEXT, parentId));
        parentId++;
    }


    private static void getIntroduceList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "ReactiveX", " ", "什么是Rx，Rx的理念和优势", CommonString.SPLASH_INDEX_URL, OperatorsUrl.INTRODUCE, parentId));
        alloperatorses.add(new AllOperators(i++, "RxJava入门指南", " ", "RxJava入门指南", CommonString.SPLASH_INDEX_URL, OperatorsUrl.GUIDE_OPEN, parentId));
        alloperatorses.add(new AllOperators(i++, "RxJava使用示例", " ", "RxJava使用示例", CommonString.SPLASH_INDEX_URL, OperatorsUrl.SAMPLE_FIRST, parentId));
        alloperatorses.add(new AllOperators(i++, "Observables", " ", "简要介绍Observable的观察者模型", CommonString.OBSERVABLES, OperatorsUrl.OBSERVABLES, parentId));
        alloperatorses.add(new AllOperators(i++, "Single", " ", "一种特殊的只发射单个值的Observable", CommonString.SPLASH_INDEX_URL, OperatorsUrl.SINGLE, parentId));
        alloperatorses.add(new AllOperators(i++, "Subject", " ", "Observable和Observer的复合体，也是二者的桥梁", CommonString.SUBJECT, OperatorsUrl.SUBJECT, parentId));
        alloperatorses.add(new AllOperators(i++, "Scheduler", " ", "介绍了各种异步任务调度和默认调度器", CommonString.SPLASH_INDEX_URL, OperatorsUrl.SCHEDULE, parentId));
        parentId++;
    }

    private static void getCreatingList(List<AllOperators> alloperatorses) {

        alloperatorses.add(new AllOperators(i++, "just()", DEFAULT, "将一个或多个对象转换成发射这个或这些对象的一个Observable", CommonString.JUST, OperatorsUrl.JUST, parentId));
        alloperatorses.add(new AllOperators(i++, "from()", DEFAULT, "将一个Iterable, 一个Future, 或者一个数组转换成一个Observable", CommonString.FROM, OperatorsUrl.FROM, parentId));
        alloperatorses.add(new AllOperators(i++, "repeat()", TRAMPOLINE, "创建一个重复发射指定数据或数据序列的Observable", CommonString.REPEAT, OperatorsUrl.REPEAT, parentId));
        alloperatorses.add(new AllOperators(i++, "repeatWhen()", TRAMPOLINE, "创建一个重复发射指定数据或数据序列的Observable，它依赖于另一个Observable发射的数据", CommonString.REPEAT_WHEN, OperatorsUrl.REPEAT, parentId));
        alloperatorses.add(new AllOperators(i++, "create()", DEFAULT, "使用一个函数从头创建一个Observable", CommonString.CREATE, OperatorsUrl.CREATE, parentId));
        alloperatorses.add(new AllOperators(i++, "defer()", DEFAULT, "只有当订阅者订阅才创建Observable；为每个订阅创建一个新的Observable", CommonString.DEFER, OperatorsUrl.DEFER, parentId));
        alloperatorses.add(new AllOperators(i++, "range()", DEFAULT, "创建一个发射指定范围的整数序列的Observable", CommonString.RANGE, OperatorsUrl.DEFER, parentId));
        alloperatorses.add(new AllOperators(i++, "interval()", COMPUTATION, "创建一个按照给定的时间间隔发射整数序列的Observable", CommonString.INTERVAL, OperatorsUrl.INTERVAL, parentId));
        alloperatorses.add(new AllOperators(i++, "timer()", COMPUTATION, "创建一个按照给定的时间间隔发射整数序列的Observable", CommonString.TIMER, OperatorsUrl.TIMER, parentId));
        alloperatorses.add(new AllOperators(i++, "empty()", DEFAULT, "创建一个什么都不做直接通知完成的Observable", CommonString.EMPTY, OperatorsUrl.EMPTY, parentId));
        alloperatorses.add(new AllOperators(i++, "error()", DEFAULT, "创建一个什么都不做直接通知错误的Observable", CommonString.EMPTY, OperatorsUrl.EMPTY, parentId));
        alloperatorses.add(new AllOperators(i++, "never()", DEFAULT, "创建一个不发射任何数据的Observable", CommonString.EMPTY, OperatorsUrl.EMPTY, parentId));
        parentId++;
    }

    private static void getTransformList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "map()", DEFAULT, "对序列的每一项都应用一个函数来变换Observable发射的数据序列", CommonString.MAP, OperatorsUrl.MAP, parentId));
        alloperatorses.add(new AllOperators(i++, "flatMap()", DEFAULT, "将Observable发射的数据集合变换为Observables集合，然后将这些Observable发射的数据平坦化的放进一个单独的Observable", CommonString.FLATMAP, OperatorsUrl.FLATMAP, parentId));
        alloperatorses.add(new AllOperators(i++, "concatMap()", DEFAULT, "将Observable发射的数据集合变换为Observables集合，然后将这些Observable发射的数据平坦化的放进一个单独的Observable", CommonString.CONTACTMAP, OperatorsUrl.CONTACTMAP, parentId));
        alloperatorses.add(new AllOperators(i++, "switchMap()", DEFAULT, "将Observable发射的数据集合变换为Observables集合，然后只发射这些Observables最近发射的数据", CommonString.SWITCHMAP, OperatorsUrl.SWITCHMAP, parentId));
        alloperatorses.add(new AllOperators(i++, "scan()", DEFAULT, "对Observable发射的每一项数据应用一个函数，然后按顺序依次发射每一个值", CommonString.SCAN, OperatorsUrl.SCAN, parentId));
        alloperatorses.add(new AllOperators(i++, "groupBy()", DEFAULT, "将Observable分拆为Observable集合，将原始Observable发射的数据按Key分组，每一个Observable发射一组不同的数据", CommonString.GROUPBY, OperatorsUrl.GROUPBY, parentId));
        alloperatorses.add(new AllOperators(i++, "buffer()", COMPUTATION, "它定期从Observable收集数据到一个集合，然后把这些数据集合打包发射，而不是一次发射一个", CommonString.BUFFER, OperatorsUrl.BUFFER, parentId));
        alloperatorses.add(new AllOperators(i++, "window()", COMPUTATION, "定期将来自Observable的数据分拆成一些Observable窗口，然后发射这些窗口，而不是每次发射一项", CommonString.WINDOW, OperatorsUrl.WINDOW, parentId));
        alloperatorses.add(new AllOperators(i++, "cast()", DEFAULT, "在发射之前强制将Observable发射的所有数据转换为指定类型", CommonString.CAST, OperatorsUrl.CAST, parentId));
        parentId++;
    }

    private static void getFilterList(List<AllOperators> alloperatorses) {
        alloperatorses.add(new AllOperators(i++, "filter()", DEFAULT, "过滤数据", CommonString.FILTER, OperatorsUrl.FILTER, parentId));
        alloperatorses.add(new AllOperators(i++, "takeLast()", DEFAULT, "只发射最后的N项数据", CommonString.TAKE_LAST, OperatorsUrl.TAKE_LAST, parentId));
        alloperatorses.add(new AllOperators(i++, "last()", DEFAULT, "只发射最后的一项数据", CommonString.LAST, OperatorsUrl.LAST, parentId));
        alloperatorses.add(new AllOperators(i++, "lastOrDefault()", DEFAULT, "只发射最后的一项数据，如果Observable为空就发射默认值", CommonString.LAST_OR_DEFAULT, OperatorsUrl.LAST_OR_DEFAULT, parentId));
        alloperatorses.add(new AllOperators(i++, "takeLastBuffer()", DEFAULT, "将最后的N项数据当做单个数据发射", CommonString.TAKE_LAST_BUFFER, OperatorsUrl.TAKE_LAST_BUFFER, parentId));
        alloperatorses.add(new AllOperators(i++, "skip()", DEFAULT, "跳过开始的N项数据", CommonString.SKIP, OperatorsUrl.SKIP, parentId));
        alloperatorses.add(new AllOperators(i++, "skipLast()", DEFAULT, "跳过最后的N项数据", CommonString.SKIP_LAST, OperatorsUrl.SKIP_LAST, parentId));
        alloperatorses.add(new AllOperators(i++, "take()", DEFAULT, "只发射开始的N项数据", CommonString.TAKE, OperatorsUrl.TAKE, parentId));
        alloperatorses.add(new AllOperators(i++, "first() and takeFirst()", DEFAULT, "只发射第一项数据，或者满足某种条件的第一项数据", CommonString.FIRST, OperatorsUrl.FIRST, parentId));
        alloperatorses.add(new AllOperators(i++, "firstOrDefault()", DEFAULT, "只发射第一项数据，如果Observable为空就发射默认值", CommonString.FIRST_DEFAULT, OperatorsUrl.FIRST_DEFAULT, parentId));
        alloperatorses.add(new AllOperators(i++, "elementAt()", DEFAULT, "发射第N项数据", CommonString.ELEMENT_AT, OperatorsUrl.ELEMENT_AT, parentId));
        alloperatorses.add(new AllOperators(i++, "elementAtOrDefault()", DEFAULT, "发射第N项数据，如果Observable数据少于N项就发射默认值", CommonString.ELEMENT_DEFAULT, OperatorsUrl.ELEMENT_DEFAULT, parentId));
        alloperatorses.add(new AllOperators(i++, "sample() or throttleLast()", DEFAULT, "定期发射Observable最近的数据", CommonString.SAMPLE, OperatorsUrl.SAMPLE, parentId));
        alloperatorses.add(new AllOperators(i++, "throttleFirst()", COMPUTATION, "定期发射Observable发射的第一项数据", CommonString.THROLFIRST, OperatorsUrl.THROLFIRST, parentId));
        alloperatorses.add(new AllOperators(i++, "throttleWithTimeout() or debounce()", DEFAULT, "只有当Observable在指定的时间后还没有发射数据时，才发射一个数据", CommonString.DEBOUND, OperatorsUrl.DEBOUND, parentId));
        alloperatorses.add(new AllOperators(i++, "timeout()", "immediate", "如果在一个指定的时间段后还没发射数据，就发射一个异常", CommonString.TIMEOUT, OperatorsUrl.TIMEOUT, parentId));
        alloperatorses.add(new AllOperators(i++, "distinct()", DEFAULT, "过滤掉重复数据", CommonString.DISTINCT, OperatorsUrl.DISTINCT, parentId));
        alloperatorses.add(new AllOperators(i++, "distinctUntilChanged()", DEFAULT, "过滤掉连续重复的数据", CommonString.UNTILCHANGED, OperatorsUrl.UNTILCHANGED, parentId));
        alloperatorses.add(new AllOperators(i++, "ofType()", DEFAULT, "只发射指定类型的数据", CommonString.OF_TYPE, OperatorsUrl.OF_TYPE, parentId));
        alloperatorses.add(new AllOperators(i++, "ignoreElements()", DEFAULT, "丢弃所有的正常数据，只发射错误或完成通知", CommonString.IGNORE_ELEMENT, OperatorsUrl.IGNORE_ELEMENT, parentId));
        parentId++;
    }
}
