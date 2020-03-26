package com.kelthuzadx.ystream;

public class JustStreamFromArray extends JustStream {
    private int[] items;

    public JustStreamFromArray(int... items){
        this.items = items;
    }

    @Override
    public void subscribe(Observer observer) {
        for(int i:items){
            observer.onNext(i);
        }
    }
}
