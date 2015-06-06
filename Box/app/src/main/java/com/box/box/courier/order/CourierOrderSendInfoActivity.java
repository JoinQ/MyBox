package com.box.box.courier.order;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.util.Utils;
import com.google.zxing.WriterException;

public class CourierOrderSendInfoActivity extends BoxActivity {
    private TextView ywmText;
    private ImageView ywmImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courier_ordersend_info);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("订单详情");

        initView();
    }

    private void initView() {
        ywmText = (TextView) findViewById(R.id.courier_ordersend_info_yym_text);
        ywmImg = (ImageView) findViewById(R.id.courier_ordersend_info_yym_img);

        String OneDCode = "123456789012";
        char[] one = OneDCode.toCharArray();
        try {
            ywmImg.setImageBitmap(Utils.createOneDCode(OneDCode));
            for (int i = 0; i < OneDCode.length(); i++) {
                ywmText.setText(ywmText.getText().toString() + one[i] + "");
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
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
