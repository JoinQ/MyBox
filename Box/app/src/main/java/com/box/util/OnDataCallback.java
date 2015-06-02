package com.box.util;

public interface OnDataCallback<T> {
    void callback(T... list);
    void error(String info);
}
