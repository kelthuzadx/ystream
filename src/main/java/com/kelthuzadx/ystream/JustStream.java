package com.kelthuzadx.ystream;

import java.util.function.Consumer;
import java.util.function.Function;

abstract class JustStream<T> {
    public static <K> JustStream<K> just(K... item) {
        return new JustStreamFromArray<K>(item);
    }

    public void subscribe(Consumer<T> func) {
        subscribeImpl(new SubscribeObserver<T>(func));
    }

    protected abstract void subscribeImpl(Observer<T> observer);

    public JustStreamOperation<T> map(Function<T, T> f) {
        return new JustStreamMap<T>(this, f);
    }

    static class SubscribeObserver<T> implements Observer<T> {
        private Consumer<T> func;

        public SubscribeObserver(Consumer<T> func) {
            this.func = func;
        }

        @Override
        public void onNext(T item) {
            func.accept(item);
        }
    }
}