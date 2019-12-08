package com.partscrib.partscribmanagementsystem.model;

public class BulletinModel {

    private String id, date, message, title, urgency;

    public BulletinModel(){}

    public BulletinModel(String id, String date, String message, String title, String urgency) {
        this.id = id;
        this.date = date;
        this.message = message;
        this.title = title;
        this.urgency = urgency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }


}
