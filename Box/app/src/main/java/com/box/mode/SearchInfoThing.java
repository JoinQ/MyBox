package com.box.mode;

public class SearchInfoThing {
    private String name;
    private String phone;
    private String beck;

    public SearchInfoThing(String beck, String name, String phone) {
        this.beck = beck;
        this.name = name;
        this.phone = phone;
    }

    public String getBeck() {
        return beck;
    }

    public void setBeck(String beck) {
        this.beck = beck;
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
}
