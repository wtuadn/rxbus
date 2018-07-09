package com.wtuadn.rxbus;

import android.support.annotation.NonNull;

import io.reactivex.functions.Predicate;

final class BusPredicate<T, O> implements Predicate<BusEvent<T, O>> {

    private T tag;
    private Class<O> clazz;

    private BusPredicate(@NonNull T tag, @NonNull Class<O> clazz) {
        this.tag = tag;
        this.clazz = clazz;
    }

    public static <T, O> BusPredicate create(@NonNull T tag, @NonNull Class<O> clazz) {
        return new BusPredicate<>(tag, clazz);
    }

    @Override
    public boolean test(BusEvent other) throws Exception {
        // If the event is consistent with the type of event required by the subscriber
        return tag.equals(other.getTag()) && clazz.isAssignableFrom(other.getObj().getClass());
    }
}