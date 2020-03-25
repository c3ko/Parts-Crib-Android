package com.partscrib.partscribmanagementsystem.model;

import java.util.List;
import java.util.Map;

public class UserDataModel {
    String id;
    String email;
    String firstName;
    String studentNumber;
    Map<String, RequestModel> requests;
    String currentPinEntry;

    public UserDataModel(String id, String email, String firstName, String studentNumber, Map<String, RequestModel> requests, String currentPinEntry) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.studentNumber = studentNumber;
        this.requests = requests;
        this.currentPinEntry = currentPinEntry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Map<String, RequestModel> getRequests() {
        return requests;
    }

    public void setRequests(Map<String, RequestModel> requests) {
        this.requests = requests;
    }

    public String getCurrentPinEntry() {
        return currentPinEntry;
    }

    public void setCurrentPinEntry(String currentPinEntry) {
        this.currentPinEntry = currentPinEntry;
    }


}
