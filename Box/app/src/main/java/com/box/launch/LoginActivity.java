package com.box.launch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.box.mode.LoginThing;
import com.box.util.Constant;
import com.box.util.OnDataCallback;
import com.box.util.RequestNetWork;
import com.box.util.Utils;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.ForgetPage;
import cn.smssdk.gui.RegisterPage;

import static com.mob.tools.utils.R.getBitmapRes;

public class LoginActivity extends BoxActivity implements View.OnClickListener {
    private Button loginBtn;
    private EditText userEdt;
    private EditText passwordEdt;
    private Button registerBtn;
    private TextView forgetPassword;
    private ImageView headImg;
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
        loginBtn = (Button) findViewById(R.id.login_bt_login);
        userEdt = (EditText) findViewById(R.id.login_et_id);
        passwordEdt = (EditText) findViewById(R.id.login_et_password);
        forgetPassword = (TextView) findViewById(R.id.login_tv_forget);
        headImg = (ImageView) findViewById(R.id.login_iv_head);
        registerBtn = (Button) findViewById(R.id.login_bt_register);

        login_return.setOnClickListener(this);
        loginBtn.setOnClickListener(this); //登陆
        registerBtn.setOnClickListener(this); //忘记密码
        forgetPassword.setOnClickListener(this); //注册
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
                if (!TextUtils.isEmpty(userEdt.getText().toString()) && !TextUtils.isEmpty(passwordEdt.getText().toString())) {
                    loginBtn.setClickable(false);
                    RequestNetWork.loginRequest(userEdt.getText().toString(), passwordEdt.getText().toString(), new OnDataCallback<LoginThing>() {
                        @Override
                        public void callback(LoginThing... list) {
                            loginBtn.setClickable(true);
                            if (list[0].getType() == Constant.ISCUSTOMER) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                startActivity(new Intent(LoginActivity.this, CourierMainActivity.class));
                            }
                            finish();
                        }

                        @Override
                        public void error(String info) {
                            loginBtn.setClickable(true);
                            startActivity(new Intent(LoginActivity.this, CourierMainActivity.class));
                            finish();
                        }
                    });
                } else if (TextUtils.isEmpty(userEdt.getText().toString()) && TextUtils.isEmpty(passwordEdt.getText().toString())){
                    Utils.Toast("用户名和密码不能为空！");
                    loginBtn.setClickable(true);
                    startActivity(new Intent(LoginActivity.this, CourierMainActivity.class));
                    finish();
                } else if (TextUtils.isEmpty(userEdt.getText().toString()) && !TextUtils.isEmpty(passwordEdt.getText().toString())) {
                    Utils.Toast("密码不能为空！");
                    loginBtn.setClickable(true);
                    startActivity(new Intent(LoginActivity.this, CourierMainActivity.class));
                    finish();
                } else {
                    Utils.Toast("用户名不能为空！");
                    loginBtn.setClickable(true);
                    startActivity(new Intent(LoginActivity.this, CourierMainActivity.class));
                    finish();
                }
                break;
            case R.id.login_bt_register:
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