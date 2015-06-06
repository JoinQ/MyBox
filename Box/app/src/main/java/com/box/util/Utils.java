package com.box.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 放一些功能进去
 */
public class Utils {
    private static Context mApplcationContent;

    public static void initialize(Application app) {
        mApplcationContent = app.getApplicationContext();
    }

    /**
     * 取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = mApplcationContent.getResources()
                .getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 取屏幕高度
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = mApplcationContent.getResources()
                .getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 快捷的吐司显示
     *
     * @param content
     */
    public static void Toast(String content) {
        Toast.makeText(mApplcationContent, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * dp转px
     */
    public static int dip2px(float dpValue) {
        final float scale = mApplcationContent.getResources()
                .getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     */
    public static int px2dip(float pxValue) {
        final float scale = mApplcationContent.getResources()
                .getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 得到SharePreferences文件
     *
     * @return
     */
    public static SharedPreferences getPreference() {
        return mApplcationContent.getSharedPreferences(Constant.LOCAL_SP,
                Activity.MODE_PRIVATE);
    }

    /**
     * 时间戳转环
     *
     * @param code
     * @return
     */

    public static String getTime(long code) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(code * 1000L));
        return date;
    }

    /**
     * 是否有网络
     *
     * @return
     */
    public static boolean isNetWorkAvilable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mApplcationContent
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo == null || !activeNetInfo.isAvailable()) {
            return false;
        } else {
            return true;
        }
    }

    public static Bitmap createOneDCode(String content) throws WriterException {
        BitMatrix matrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.CODE_128, 1000, 400);
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

    public static class QuickClick {
        public static long lastClickTime;

        public static boolean isQuickClick() {

            long currentTime = System.currentTimeMillis();
            long time = currentTime - lastClickTime;

            if (0 < time && time < 600) {
                return true;
            } else {
                lastClickTime = currentTime;
                return false;
            }
        }
    }

}
