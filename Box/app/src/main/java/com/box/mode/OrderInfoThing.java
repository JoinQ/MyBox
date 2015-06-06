package com.box.mode;


public class OrderInfoThing {
    private String number;
    private String address;

    public OrderInfoThing(String address, String number) {
        this.address = address;
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
