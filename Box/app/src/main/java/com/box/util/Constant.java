package com.box.util;

/**
 * 常量
 */
public class Constant {
    public static final String LOCAL_SP = "box";

    public static final int ISCOURIER = 0;
    public static final int ISCUSTOMER = 1;

    public class Api {
        public static final String LOGIN = "http://172.27.23.1:5000/Service1.asmx/selectAllCargoInfor";

        public class params {
            public static final String USERNAME = "username";
            public static final String PASSWORD = "password";
        }

        public class key {
            public static final String STATUS = "status";
            public static final String DATA = "data";

            public static final int SUCCESS = 200;
            public static final int FAIL = 400;
        }
    }
}
