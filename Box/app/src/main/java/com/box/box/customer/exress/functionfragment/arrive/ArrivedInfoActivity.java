package com.box.box.customer.exress.functionfragment.arrive;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.box.customer.MainActivity;
import com.box.util.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class ArrivedInfoActivity extends BoxActivity implements View.OnClickListener {

    private TextView erroText;
    private TextView ywmText;
    private ImageView ywmImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrived_not_receive);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("我的快递");
        init();
    }

    private void init() {
        erroText = (TextView) findViewById(R.id.arr_not_rec_tv_exception);
        ywmText = (TextView) findViewById(R.id.arr_not_rec_tv_ywm);
        ywmImg = (ImageView) findViewById(R.id.arr_not_rec_iv_ywm);

        String OneDCode = "123456789012";
        char[] one = OneDCode.toCharArray();
        try {
            ywmImg.setImageBitmap(Utils.createOneDCode(OneDCode));
            for (int i = 0; i < OneDCode.length(); i++) {
                ywmText.setText(ywmText.getText().toString() + one[i] + "  ");
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        erroText.setOnClickListener(this);
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
            case R.id.arr_not_rec_tv_exception:
                new AlertDialog.Builder(ArrivedInfoActivity.this).setTitle("取件遇到问题？")
                        .setMessage("请用以下密码取件：" + "123456")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
        }
    }
}
