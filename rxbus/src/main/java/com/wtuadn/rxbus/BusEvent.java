package com.wtuadn.rxbus;

import android.support.annotation.NonNull;

public class BusEvent<T, O> {
    private T tag;
    private O obj;

    private BusEvent(T tag, O obj) {
        this.tag = tag;
        this.obj = obj;
    }

    static <T, O> BusEvent<T, O> create(@NonNull T eventTag, @NonNull O eventContent) {
        return new BusEvent<>(eventTag, eventContent);
    }

    @NonNull
    public T getTag() {
        return tag;
    }

    public void setTag(T tag) {
        this.tag = tag;
    }

    @NonNull
    public O getObj() {
        return obj;
    }

    public void setObj(O obj) {
        this.obj = obj;
    }
}