package com.kelthuzadx.ystream;

public class YStreamFromArray<T> extends YStream<T> {
    private T[] items;

    public YStreamFromArray(T... items) {
        this.items = items;
    }


    @Override
    protected void subscribeImpl(Observer<T> downstream) {
        for (T i : items) {
            downstream.onNext(i);
        }
    }
}
