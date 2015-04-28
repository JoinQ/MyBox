package com.box.launch;

import android.content.Intent;
import android.os.Bundle;

import com.box.app.BoxActivity;
import com.box.box.customer.MainActivity;

public class LaunchActivity extends BoxActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
