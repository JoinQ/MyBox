package com.box.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.box.util.Utils;
import com.umeng.update.UmengUpdateAgent;

public class BoxActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UmengUpdateAgent.update(this);
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
