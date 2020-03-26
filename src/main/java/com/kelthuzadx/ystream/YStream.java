package com.kelthuzadx.ystream;


import java.util.function.Consumer;


public abstract class YStream {


    public static void main(String[] args) {
        JustStream.just(1,2,3).map(f->f+1).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
//        Observable.just(12,3).map(f->f+1).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                System.out.println(integer);
//            }
//        });
    }
}
