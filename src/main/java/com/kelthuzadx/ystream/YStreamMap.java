package com.kelthuzadx.ystream;

import java.util.function.Function;

public class YStreamMap<T> extends YStreamOperation<T> {
    private Function<T, T> func;

    public YStreamMap(YStream<T> source, Function<T, T> func) {
        super(source);
        this.func = func;
    }

    @Override
    protected void subscribeImpl(Observer<T> observer) {
        source.subscribeImpl(new MapObserver<T>(observer, func));
    }

    public static class MapObserver<T> implements Observer<T> {
        private Observer<T> observer;
        private Function<T, T> func;

        public MapObserver(Observer<T> observer, Function<T, T> func) {
            this.observer = observer;
            this.func = func;
        }

        @Override
        public void onNext(T item) {
            T i = func.apply(item);
            observer.onNext(i);
        }
    }
}
