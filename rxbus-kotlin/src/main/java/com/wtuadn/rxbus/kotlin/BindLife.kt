package com.wtuadn.rxbus.kotlin

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import com.wtuadn.rxbus.RxUtils
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Created by wtuadn on 2018/6/6.
 */
inline fun <T> Observable<T>.bindLife(o: LifecycleOwner, untilEvent: Lifecycle.Event? = null, noinline c: (t: T) -> Unit): Disposable {
    return if (untilEvent == null) `as`(RxUtils.bindLifecycle(o)).subscribe(c)
    else `as`(RxUtils.bindLifecycle(o, untilEvent)).subscribe(c)
}

inline fun <T> Single<T>.bindLife(o: LifecycleOwner, untilEvent: Lifecycle.Event? = null, noinline c: (t: T) -> Unit): Disposable {
    return if (untilEvent == null) `as`(RxUtils.bindLifecycle(o)).subscribe(c)
    else `as`(RxUtils.bindLifecycle(o, untilEvent)).subscribe(c)
}

inline fun <T> Maybe<T>.bindLife(o: LifecycleOwner, untilEvent: Lifecycle.Event? = null, noinline c: (t: T) -> Unit): Disposable {
    return if (untilEvent == null) `as`(RxUtils.bindLifecycle(o)).subscribe(c)
    else `as`(RxUtils.bindLifecycle(o, untilEvent)).subscribe(c)
}

inline fun <T> Flowable<T>.bindLife(o: LifecycleOwner, untilEvent: Lifecycle.Event? = null, noinline c: (t: T) -> Unit): Disposable {
    return if (untilEvent == null) `as`(RxUtils.bindLifecycle(o)).subscribe(c)
    else `as`(RxUtils.bindLifecycle(o, untilEvent)).subscribe(c)
}