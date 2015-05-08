package com.box.app;

import android.app.Application;
import com.box.util.Utils;
import cn.smssdk.SMSSDK;

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
        SMSSDK.initSDK(this, "722fca824f74", "8bc7a3d388921575fa132f65da3cdf8e");
    }
}
