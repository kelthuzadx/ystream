package com.kelthuzadx.ystream;

public abstract class JustStreamOperation extends JustStream {
    protected JustStream source;
    public JustStreamOperation(JustStream source) {
        this.source = source;
    }
}
