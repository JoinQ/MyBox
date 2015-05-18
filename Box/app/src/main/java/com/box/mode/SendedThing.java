package com.box.mode;

public class SendedThing {
    private String number;
    private int headImgId;
    private String name;
    private String phone;
    private String state;
    private String pinglun;

    public SendedThing(String number, int headImgId, String name, String phone, String state, String pinglun) {
        this.number = number;
        this.headImgId = headImgId;
        this.name = name;
        this.phone = phone;
        this.state = state;
        this.pinglun = pinglun;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinglun() {
        return pinglun;
    }

    public void setPinglun(String pinglun) {
        this.pinglun = pinglun;
    }
}
