package com.puan.looptestdev.entity;

public class Device {
    private String bleName;
    private String bleMac;

    public Device(String bleName, String bleMac) {
        this.bleName = bleName;
        this.bleMac = bleMac;
    }

    public String getBleName() {
        return bleName;
    }

    public String getBleMac() {
        return bleMac;
    }

    public void setBleName(String bleName) {
        this.bleName = bleName;
    }

    public void setBleMac(String bleMac) {
        this.bleMac = bleMac;
    }
}
