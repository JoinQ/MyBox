package com.box.mode;


public class SiteThing {
    private String site;
    private int amout;

    public SiteThing(String site, int amout) {
        this.site = site;
        this.amout = amout;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
