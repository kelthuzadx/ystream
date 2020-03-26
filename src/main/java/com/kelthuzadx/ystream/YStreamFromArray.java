package com.kelthuzadx.ystream;

public class YStreamFromArray<T> extends YStream<T> {
    private T[] items;

    @SafeVarargs
    public YStreamFromArray(T... items) {
        this.items = items;
    }

    @Override
    protected void subscribeImpl(Observer<T> observer) {
        for (T i : items) {
            observer.onNext(i);
        }
    }
}
