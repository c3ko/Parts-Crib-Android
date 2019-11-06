package com.partscrib.partscribmanagementsystem.model;

public class PartModel {

    private String name;
    private String inPartsKit;

    public PartModel(String name, String inPartsKit) {
        this.name = name;
        this.inPartsKit = inPartsKit;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getInPartsKit() {
        return inPartsKit;
    }

    public void setInPartsKit(String inPartsKit) {
        this.inPartsKit = inPartsKit;
    }
}
