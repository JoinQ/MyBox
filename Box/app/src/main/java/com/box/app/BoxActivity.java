package com.box.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.box.util.Utils;
import com.umeng.analytics.MobclickAgent;

public class BoxActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (Utils.QuickClick.isQuickClick()) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
