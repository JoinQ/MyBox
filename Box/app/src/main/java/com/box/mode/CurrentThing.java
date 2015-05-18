package com.box.mode;


public class CurrentThing {
    private int headerId;
    private String name;
    private String number;
    private String userName;
    private String phone;
    private String address;

    public CurrentThing(String address, int headerId, String name, String number, String phone, String userName) {
        this.address = address;
        this.headerId = headerId;
        this.name = name;
        this.number = number;
        this.phone = phone;
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
