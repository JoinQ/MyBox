package com.box.mode;

public class Things<T, M> {
    public T[] t;
    public M[] m;

    public Things(T[] t, M[] m) {
        this.t = t;
        this.m = m;
    }

    public T[] getT() {
        return t;
    }

    public void setT(T[] t) {
        this.t = t;
    }

    public M[] getM() {
        return m;
    }

    public void setM(M[] m) {
        this.m = m;
    }
}
