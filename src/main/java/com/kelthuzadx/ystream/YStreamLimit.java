package com.kelthuzadx.ystream;

public class YStreamLimit<T> extends YStreamOperation<T> {
    private int limit;

    public YStreamLimit(YStream<T> upstream, int limit) {
        super(upstream);
        this.limit = Math.max(limit, 0);
    }

    @Override
    protected void subscribeImpl(Observer<T> downstream) {
        upstream.subscribeImpl(new LimitObserver<>(downstream, limit));
    }

    static class LimitObserver<T> implements Observer<T> {
        private final int limit;
        private Observer<T> downstream;
        private int cur;

        public LimitObserver(Observer<T> downstream, int limit) {
            this.downstream = downstream;
            this.limit = limit;
            this.cur = 0;
        }

        @Override
        public void onNext(T item) {
            if (cur >= limit) {
                return;
            }
            downstream.onNext(item);
            cur++;
        }
    }
}
