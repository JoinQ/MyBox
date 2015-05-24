package com.box.box.customer.exress.functionfragment.sendme;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.util.Utils;

public class WantSendActivity extends BoxActivity implements View.OnClickListener {

    private Button want_send_alipay;
    private Button want_send_arrivepay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_send);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("我要寄件");

        want_send_alipay = (Button) findViewById(R.id.want_send_alipay);
        want_send_arrivepay = (Button) findViewById(R.id.want_send_arrivepay);

        want_send_alipay.setOnClickListener(this);
        want_send_arrivepay.setOnClickListener(this);

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.want_send_alipay:
                want_send_alipay.setBackgroundResource(R.drawable.want_send_button_shape_on);
                want_send_alipay.setTextColor(this.getResources().getColor(R.color.want_send_button_on));

                want_send_arrivepay.setBackgroundResource(R.drawable.want_send_button_shape_off);
                want_send_arrivepay.setTextColor(this.getResources().getColor(R.color.want_send_button_off));
                break;

            case R.id.want_send_arrivepay:
                want_send_arrivepay.setBackgroundResource(R.drawable.want_send_button_shape_on);
                want_send_arrivepay.setTextColor(this.getResources().getColor(R.color.want_send_button_on));

                want_send_alipay.setBackgroundResource(R.drawable.want_send_button_shape_off);
                want_send_alipay.setTextColor(this.getResources().getColor(R.color.want_send_button_off));
                break;
        }
    }
}
