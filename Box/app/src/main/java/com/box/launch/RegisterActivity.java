package com.box.launch;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.box.customer.MainActivity;

public class RegisterActivity extends BoxActivity implements View.OnClickListener{

    private Button register_bt_return;
    private Button register_bt_next;
    private TextView register_tv_congratulations;
    private Intent intent;

    private String congratulations = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();
        congratulations = intent.getStringExtra("congratulations");

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle(congratulations);

        initView();
    }

    private void initView() {
        register_tv_congratulations = (TextView) findViewById(R.id.register_tv_congratulations);
        register_bt_return = (Button) findViewById(R.id.register_bt_return);
        register_bt_next = (Button) findViewById(R.id.register_bt_next);

        switch (congratulations) {
            case "注册成功":
                register_tv_congratulations.setText("恭喜你，注册成功");
                break;
            case "重置密码成功":
                register_tv_congratulations.setText("恭喜你，重置密码成功");
                break;
        }

        register_bt_return.setOnClickListener(this);
        register_bt_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_bt_return:
                intent = new Intent(RegisterActivity.this, LoginActivity.class);
                break;
            case R.id.register_bt_next:
                intent = new Intent(RegisterActivity.this, MainActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
        finish();
    }
}
