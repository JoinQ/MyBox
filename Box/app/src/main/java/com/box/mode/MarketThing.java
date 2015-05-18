package com.box.mode;

public class MarketThing {
    private String imgUri;
    private String name;

    public MarketThing(String name, String imgUri) {
        this.name = name;
        this.imgUri = imgUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }
}
