package com.box.box.courier.me.function;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.box.app.BoxActivity;
import com.box.app.MyApplication;
import com.box.box.R;
import com.box.launch.LoginActivity;
import com.box.mode.SettingThing;
import com.box.widget.BaseRecyclerAdapter;
import com.box.widget.SettingRecyclerAdapter;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;
import com.umeng.update.UpdateStatus;

import java.util.ArrayList;
import java.util.List;

public class CourierSettingActivity extends BoxActivity implements BaseRecyclerAdapter.OnRecyclerItemClickListener {
    private RecyclerView recyclerView;

    private SettingRecyclerAdapter adapter;
    private List<SettingThing> list = new ArrayList<SettingThing>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("设置");

        list.add(new SettingThing(R.drawable.set_modify_password, "修改密码", true));
        list.add(new SettingThing(R.drawable.set_update_checked, "检查更新", false));
        list.add(new SettingThing(R.drawable.set_feedback, "反馈", true));
        list.add(new SettingThing(R.drawable.set_about_us, "关于我们", false));
        list.add(new SettingThing(R.drawable.set_change_user, "切换帐号", true));
        list.add(new SettingThing(R.drawable.set_exit, "退出", false));

        adapter = new SettingRecyclerAdapter(list, this);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.setting_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
        adapter.setOnRecyclerOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View v, int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                UmengUpdateAgent.forceUpdate(this);

                UmengUpdateAgent.setUpdateListener(new UmengUpdateListener() {
                    @Override
                    public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
                        switch (updateStatus) {
                            case UpdateStatus.Yes:
                                UmengUpdateAgent.showUpdateDialog(CourierSettingActivity.this, updateInfo);
                                break;
                            case UpdateStatus.No:
                                Toast.makeText(CourierSettingActivity.this, "没有更新", Toast.LENGTH_SHORT).show();
                                break;
                            case UpdateStatus.Timeout:
                                Toast.makeText(CourierSettingActivity.this, "超时", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                UmengUpdateAgent.update(this);

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                MyApplication.getInstance().exitAllActivity();
                startActivity(new Intent(CourierSettingActivity.this, LoginActivity.class));
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
}