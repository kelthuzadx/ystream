package com.kelthuzadx.ystream;

public class JustStreamFromArray<T> extends JustStream<T> {
    private T[] items;

    public JustStreamFromArray(T... items) {
        this.items = items;
    }

    @Override
    protected void subscribeImpl(Observer<T> observer) {
        for (T i : items) {
            observer.onNext(i);
        }
    }
}
