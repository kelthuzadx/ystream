package com.kelthuzadx.ystream;

import java.util.function.Predicate;

public class YStreamFilter<T> extends YStreamOperation<T> {
    private Predicate<T> predicate;

    public YStreamFilter(YStream<T> upstream, Predicate<T> predicate) {
        super(upstream);
        this.predicate = predicate;
    }

    @Override
    protected void subscribeImpl(Observer<T> downstream) {
        upstream.subscribeImpl(new FilterObserver<>(downstream, predicate));
    }

    static class FilterObserver<T> implements Observer<T> {
        private Observer<T> observer;
        private Predicate<T> predicate;

        public FilterObserver(Observer<T> observer, Predicate<T> predicate) {
            this.observer = observer;
            this.predicate = predicate;
        }

        @Override
        public void onNext(T item) {
            boolean result = predicate.test(item);
            if (result) {
                observer.onNext(item);
            }
        }
    }

}
