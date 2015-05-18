package com.box.mode;

public class QueryingGThing {
    private String number;
    private int headImgId;
    private String name;
    private String phone;
    private String time;
    private String state;

    public QueryingGThing(String number, int headImgId, String name, String phone, String time, String state) {
        this.number = number;
        this.headImgId = headImgId;
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getHeadImgId() {
        return headImgId;
    }

    public void setHeadImgId(int headImgId) {
        this.headImgId = headImgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
