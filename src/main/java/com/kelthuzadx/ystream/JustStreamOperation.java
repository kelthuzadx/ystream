package com.kelthuzadx.ystream;

public abstract class JustStreamOperation<T> extends JustStream<T> {
    protected JustStream<T> source;

    public JustStreamOperation(JustStream<T> source) {
        this.source = source;
    }
}
