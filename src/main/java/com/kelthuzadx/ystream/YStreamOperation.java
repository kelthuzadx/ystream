package com.kelthuzadx.ystream;

public abstract class YStreamOperation<T> extends YStream<T> {
    protected YStream<T> upstream;

    public YStreamOperation(YStream<T> upstream) {
        this.upstream = upstream;
    }
}
