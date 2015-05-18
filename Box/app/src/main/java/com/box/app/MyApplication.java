package com.box.app;

import android.app.Activity;
import android.app.Application;
import com.box.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import cn.smssdk.SMSSDK;

public class MyApplication extends Application {
    public static MyApplication instance;
    private List<Activity> activityList = new ArrayList<Activity>();
    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.initialize(this);
        SMSSDK.initSDK(this, "722fca824f74", "8bc7a3d388921575fa132f65da3cdf8e");
        Fresco.initialize(this);
    }

    public void addActivity(Activity activty) {
        activityList.add(activty);
    }

    public void destroyActivity(Activity activity) {
        if (activityList.contains(activity)) {
            activityList.remove(activity);
        }
    }

    public void exitAllActivity() {
        try {
            for (Activity activity:activityList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
