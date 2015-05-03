package com.box.mode;

public class QueryInfoThing {

    public int image;
    public String status;
    public String time;

    public QueryInfoThing(int image, String status, String time) {
        this.image = image;
        this.status = status;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
