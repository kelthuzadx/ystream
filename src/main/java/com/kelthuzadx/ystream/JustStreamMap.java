package com.kelthuzadx.ystream;

import java.util.function.Function;

public class JustStreamMap extends JustStreamOperation {
    private Function<Integer,Integer> func;

    public JustStreamMap(JustStream source,Function<Integer,Integer> func) {
        super(source);
        this.func = func;
    }

    @Override
    public void subscribe(Observer observer) {
        source.subscribe(new MapObserver(observer,func));
    }

    public static class MapObserver implements Observer{
        private Observer observer;
        private Function<Integer,Integer> func;

        public MapObserver(Observer observer,Function<Integer,Integer> func) {
            this.observer = observer;
            this.func = func;
        }

        @Override
        public void onNext(int item) {
            int i = func.apply(item);
            observer.onNext(i);
        }
    }
}
