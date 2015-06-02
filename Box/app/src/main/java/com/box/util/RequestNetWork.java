package com.box.util;

import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.box.app.ResultRequestCallback;
import com.box.mode.LoginThing;

public class RequestNetWork {

    public static void loginRequest (String username, String password, final OnDataCallback<LoginThing> callback) {
        RequestMap params = new RequestMap();
        params.put(Constant.Api.params.USERNAME, username);
        params.put(Constant.Api.params.PASSWORD, password);

        RequestManager.getInstance().post(Constant.Api.LOGIN, params, new ResultRequestCallback<LoginThing>(LoginThing.class) {
            @Override
            public void success(LoginThing successInfo) {
                callback.callback(successInfo);
            }

            @Override
            public void error(String errorInfo) {
                callback.error(errorInfo);
            }
        });
    }
}
