package com.kelthuzadx.ystream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class YStream<T> {
    @SafeVarargs
    public static <K> YStream<K> just(K... item) {
        return new YStreamFromArray<K>(item);
    }

    public void subscribe(Consumer<T> func) {
        subscribeImpl(new SubscribeObserver<>(func));
    }

    protected abstract void subscribeImpl(Observer<T> observer);

    public YStreamOperation<T> map(Function<T, T> f) {
        return new YStreamMap<T>(this, f);
    }

    public YStreamOperation<T> filter(Predicate<T> predicate) {
        return new YStreamFilter<T>(this, predicate);
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