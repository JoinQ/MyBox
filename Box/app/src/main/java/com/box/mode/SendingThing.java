package com.box.mode;

public class SendingThing {
    private String number;
    private int headImgId;
    private String name;
    private String phone;
    private String state;
    private String over;

    public SendingThing(String number, int headImgId, String phone, String name, String state, String over) {
        this.number = number;
        this.headImgId = headImgId;
        this.phone = phone;
        this.name = name;
        this.state = state;
        this.over = over;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }
}
