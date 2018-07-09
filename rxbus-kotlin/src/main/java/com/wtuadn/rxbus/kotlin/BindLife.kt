package com.wtuadn.rxbus.kotlin

import android.arch.lifecycle.LifecycleOwner
import com.wtuadn.rxbus.RxUtils
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by wtuadn on 2018/6/6.
 */
inline fun <T> Observable<T>.bindLife(o: LifecycleOwner, noinline c: (t: T) -> Unit) =
        this.`as`(RxUtils.bindLifecycle(o)).subscribe(c)

inline fun <T> Single<T>.bindLife(o: LifecycleOwner, noinline c: (t: T) -> Unit) =
        this.`as`(RxUtils.bindLifecycle(o)).subscribe(c)

inline fun <T> Maybe<T>.bindLife(o: LifecycleOwner, noinline c: (t: T) -> Unit) =
        this.`as`(RxUtils.bindLifecycle(o)).subscribe(c)

inline fun <T> Flowable<T>.bindLife(o: LifecycleOwner, noinline c: (t: T) -> Unit) =
        this.`as`(RxUtils.bindLifecycle(o)).subscribe(c)