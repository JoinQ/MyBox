package com.box.box.courier.me.function;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.box.customer.me.function.EditInformationActivity;
import com.box.box.customer.me.function.MyInformationActivity;
import com.box.util.Utils;

public class CourierMyInformationActivity extends BoxActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);
        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("个人信息");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_editting:
                startActivity(new Intent(CourierMyInformationActivity.this,EditCourierInformationActivity.class));
                Utils.Toast("编辑");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my_information, menu);
        return true;
    }
}
