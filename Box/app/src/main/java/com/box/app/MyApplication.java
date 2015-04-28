package com.box.app;

import android.app.Application;

import com.box.util.Utils;

public class MyApplication extends Application {
    public static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.initialize(this);
    }
}
