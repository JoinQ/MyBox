package com.box.mode;

public class ArrivedThing {
    public String number;
    public int headImgId;
    public String name;
    public String phone;
    public String time;
    public String place;

    public ArrivedThing(String number, int headImgId, String name, String phone, String time, String place) {
        this.number = number;
        this.headImgId = headImgId;
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
