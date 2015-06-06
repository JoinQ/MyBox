package com.box.box.customer.exress.functionfragment.sendme;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;

import com.box.app.BoxActivity;
import com.box.box.R;

public class SendmeInfoActivity extends BoxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wansend_info);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("订单消息");
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

}
