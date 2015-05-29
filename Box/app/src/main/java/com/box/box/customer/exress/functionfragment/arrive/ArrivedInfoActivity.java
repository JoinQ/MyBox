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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class ArrivedInfoActivity extends BoxActivity implements View.OnClickListener {

    private TextView arr_not_rec_tv_exception;
    private ImageView arr_not_rec_iv_ywm;

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
        arr_not_rec_tv_exception = (TextView) findViewById(R.id.arr_not_rec_tv_exception);
        arr_not_rec_tv_exception.setOnClickListener(this);
        arr_not_rec_iv_ywm = (ImageView) findViewById(R.id.arr_not_rec_iv_ywm);

        try {
            arr_not_rec_iv_ywm.setImageBitmap(CreateOneDCode("123456789012"));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arr_not_rec_tv_exception:
                new AlertDialog.Builder(ArrivedInfoActivity.this).setTitle("取件遇到问题？")//设置对话框标题
                        .setMessage("请用以下密码取件："+"123456")//设置显示的内容
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                            }
                        }).show();
        }
    }


    public Bitmap CreateOneDCode(String content) throws WriterException {
        BitMatrix matrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.CODE_128, 500, 200);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }


}
