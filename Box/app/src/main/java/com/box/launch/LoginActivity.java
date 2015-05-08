package com.box.launch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.box.courier.CourierMainActivity;
import com.box.box.customer.MainActivity;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.ForgetPage;
import cn.smssdk.gui.RegisterPage;

import static com.mob.tools.utils.R.getBitmapRes;

public class LoginActivity extends BoxActivity implements View.OnClickListener {
    private Button login_bt_login;
    private EditText login_et_id;
    private EditText login_et_password;
    private TextView login_tv_register;
    private TextView login_tv_forget;
    private ImageView login_iv_head;
    private LinearLayout login_return;

    private FrameLayout frameLayoutBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        frameLayoutBg = (FrameLayout) findViewById(R.id.login_frame);
        login_return = (LinearLayout) findViewById(R.id.login_ll_return);
        login_bt_login = (Button) findViewById(R.id.login_bt_login);
        login_et_id = (EditText) findViewById(R.id.login_et_id);
        login_et_password = (EditText) findViewById(R.id.login_et_password);
        login_tv_register = (TextView) findViewById(R.id.login_tv_register);
        login_tv_forget = (TextView) findViewById(R.id.login_tv_forget);
        login_iv_head = (ImageView) findViewById(R.id.login_iv_head);


        login_return.setOnClickListener(this);
        login_bt_login.setOnClickListener(this); //登陆
        login_tv_register.setOnClickListener(this); //忘记密码
        login_tv_forget.setOnClickListener(this); //注册
        login_return.destroyDrawingCache();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_ll_return:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.login_bt_login:
//                if (login_et_id.getText().toString() != null && login_et_id.getText().toString().length() == 11 && login_et_password.getText().toString() != null && login_et_password.getText().toString().length() != 0)
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                else if (login_et_id.getText().toString() == null || login_et_id.getText().toString().length() != 11) {
//                    Utils.Toast("账号错误");
//                } else if (login_et_password.getText().toString() == null || login_et_password.getText().toString().length() == 0) {
//                    Utils.Toast("密码不能为空");
//                }
                startActivity(new Intent(LoginActivity.this, CourierMainActivity.class));
                finish();
                break;
            case R.id.login_tv_register:
                RegisterPage registerPage = new RegisterPage(LoginActivity.this);
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");

                            Intent intent = new Intent();
                            intent.putExtra("congratulations", "注册成功");
                            intent.setClass(LoginActivity.this, RegisterActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                registerPage.show(LoginActivity.this);
                break;
            case R.id.login_tv_forget:
                ForgetPage forgetPage = new ForgetPage(LoginActivity.this);
                forgetPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");

                            Intent intent = new Intent();
                            intent.putExtra("congratulations", "重置密码成功");
                            intent.setClass(LoginActivity.this, RegisterActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                forgetPage.show(LoginActivity.this);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}