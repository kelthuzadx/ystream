package com.kelthuzadx.ystream;

import java.util.function.Consumer;
import java.util.function.Function;

abstract class JustStream{
    public void subscribe(Consumer<Integer> func){
        subscribe(new JustStreamObserver(func));
    }

    public abstract void subscribe(Observer observer);

    public JustStreamOperation map(Function<Integer,Integer> f){
        return new JustStreamMap(this,f);
    }

    public static JustStream just(int... item){
        return new JustStreamFromArray(item);
    }

    static class JustStreamObserver implements Observer{
        private Consumer<Integer> func;

        public JustStreamObserver(Consumer<Integer> func){
            this.func = func;
        }

        @Override
        public void onNext(int item) {
            func.accept(item);
        }
    }
}