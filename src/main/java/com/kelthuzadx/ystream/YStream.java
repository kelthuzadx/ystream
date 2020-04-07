package com.kelthuzadx.ystream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class YStream<T> {
    @SafeVarargs
    public static <K> YStream<K> just(K... item) {
        return new YStreamFromArray<K>(item);
    }

    public static YStream<Integer> range(int start, int end) {
        Integer[] arr = null;
        if (start < end) {
            arr = new Integer[end - start];
        } else {
            arr = new Integer[0];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start + i;
        }
        return new YStreamFromArray<>(arr);
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

    public YStreamOperation<T> limit(int limit) {
        return new YStreamLimit<>(this, limit);
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