package com.kelthuzadx.ystream;


public abstract class YStream {


    public static void main(String[] args) {
        JustStream.just(3.1, 6.1, 9.1).map(f -> f + 1.).subscribe(System.out::println);
    }
}
