package com.wtuadn.rxbus;

import android.support.annotation.NonNull;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;

public class RxBus {
    // Relay as event bus
    private static Relay<BusEvent> mBus;

    static {
        // to serialized method making them thread-safe
        PublishRelay<BusEvent> publishSubject = PublishRelay.create();
        mBus = publishSubject.toSerialized();
    }

    private RxBus() {
    }

    // post a event, is to execute accept
    public static <T, O> void post(@NonNull T tag, @NonNull O obj) {
        mBus.accept(BusEvent.create(tag, obj));
    }

    // observe, is to register a subscribe
    public static <T, O> Observable<O> observe(@NonNull T tag, @NonNull Class<O> clazz) {
        return mBus.filter(BusPredicate.create(tag, clazz))
                .map(busEventMapper())
                .observeOn(AndroidSchedulers.mainThread());
    }

    // has observers
    public static boolean hasObservers() {
        return mBus.hasObservers();
    }

    @NonNull
    private static <T, O> Function<BusEvent<T, O>, O> busEventMapper() {
        return new Function<BusEvent<T, O>, O>() {
            @Override
            public O apply(BusEvent<T, O> busEvent) throws Exception {
                return busEvent.getObj();
            }
        };
    }
}