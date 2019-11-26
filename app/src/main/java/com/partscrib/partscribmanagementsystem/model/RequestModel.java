package com.partscrib.partscribmanagementsystem.model;


import java.util.Map;

public class RequestModel {


    private String requestID; // Generate this random 5 digit number
    private String userID;
    private String neededTimeStamp; //When is it needed
    private String requestTimeStamp; // How long it will be borrowed
    private String requestStatus;
    private Map<String, PartRequest> parts;

    public RequestModel(String requestID, String userID, String neededTimeStamp, String requestTimeStamp, String requestStatus, Map<String, PartRequest> parts) {
        this.requestID = requestID;
        this.userID = userID;
        this.neededTimeStamp = neededTimeStamp;
        this.requestTimeStamp = requestTimeStamp;
        this.requestStatus = requestStatus;
        this.parts = parts;
    }



    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNeededTimeStamp() {
        return neededTimeStamp;
    }

    public void setNeededTimeStamp(String neededTimeStamp) {
        this.neededTimeStamp = neededTimeStamp;
    }

    public String getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(String requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Map<String, PartRequest> getParts() {
        return parts;
    }

    public void setParts(Map<String, PartRequest> parts) {
        this.parts = parts;
    }




}
