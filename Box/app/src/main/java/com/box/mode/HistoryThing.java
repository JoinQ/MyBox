package com.box.mode;

public class HistoryThing {
    public int headerId;
    public String number;
    public String time;
    public String gAddress;
    public String pAddress;
    public String comment;

    public HistoryThing(String comment, String gAddress, int headerId, String number, String pAddress, String time) {
        this.comment = comment;
        this.gAddress = gAddress;
        this.headerId = headerId;
        this.number = number;
        this.pAddress = pAddress;
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
