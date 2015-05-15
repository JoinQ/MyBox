package com.box.mode;

public class MeListThing {
    private int imageId;
    private String name;
    private Boolean isAppear;

    public MeListThing(int imageId, String name, Boolean isAppear) {
        this.imageId = imageId;
        this.isAppear = isAppear;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsAppear() {
        return isAppear;
    }

    public void setIsAppear(Boolean isAppear) {
        this.isAppear = isAppear;
    }
}
