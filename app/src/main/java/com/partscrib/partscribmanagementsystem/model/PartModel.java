package com.partscrib.partscribmanagementsystem.model;

public class PartModel {

    private String id;
    private String name;
    private String inPartsKit;
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PartModel(String id, String name, String category, String inPartsKit) {
        this.id = id;
        this.name = name;
        this.category = category;
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
