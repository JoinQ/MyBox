package com.box.mode;

public class QueryingGThing {
    private String number;
    private int headImgId;
    private String name;
    private String idNumber;
    private String time;
    private String state;

    public QueryingGThing(String number, int headImgId, String name, String idNumber, String time, String state) {
        this.number = number;
        this.headImgId = headImgId;
        this.name = name;
        this.idNumber = idNumber;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
