package com.kelthuzadx.ystream;

public abstract class YStreamOperation<T> extends YStream<T> {
    protected YStream<T> source;

    public YStreamOperation(YStream<T> source) {
        this.source = source;
    }
}
