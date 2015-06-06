package com.box.app;

import com.alibaba.fastjson.JSON;
import com.android.http.RequestManager;
import com.box.util.Constant;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

public abstract class ResultRequestCallback<T> implements RequestManager.RequestListener {
    private static final String TAG = "string";
    private Class<T> clazz;

    public ResultRequestCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void onRequest() {
    }

    @Override
    public void onSuccess(String s) {
        String json = Jsoup.parse(s).getElementsByTag(TAG).text();
        if (!json.equals(Constant.Api.key.FAIL + "")) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                int status = jsonObject.getInt(Constant.Api.key.STATUS);
                T data = JSON.parseObject(jsonObject.getString(Constant.Api.key.DATA), clazz);
                if (status == Constant.Api.key.SUCCESS) {
                    success(data);
                } else if (status == Constant.Api.key.FAIL) {
                    error("请求失败");
                }

            } catch (JSONException e) {
                error("解析失败");
            }
        } else {
            error("请求失败");
        }
    }

    @Override
    public void onError(String s) {
        error("网络错误");
    }

    public abstract void success(T successInfo);

    public abstract void error(String errorInfo);
}
