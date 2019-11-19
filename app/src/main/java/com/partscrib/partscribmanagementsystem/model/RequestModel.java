package com.partscrib.partscribmanagementsystem.model;

import java.util.ArrayList;

public class RequestModel {


    private String requestID;
    private String userID;
    private String neededTimeStamp; //When is it needed
    private String requestTimeStamp; // How long it will be borrowed
    private ArrayList<String> partsRequests; //List of partsRequestsID
    private String requestStatus;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(String requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }




    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getNeededTimeStamp() {
        return neededTimeStamp;
    }

    public void setNeededTimeStamp(String neededTimeStamp) {
        this.neededTimeStamp = neededTimeStamp;
    }

    public ArrayList<String> getPartsRequests() {
        return partsRequests;
    }

    public void setPartsRequests(ArrayList<String> partsRequests) {
        this.partsRequests = partsRequests;
    }



    public RequestModel(String requestID, String userId, String requestTimeStamp, String neededTimeStamp, ArrayList<String> partsRequests, String requestStatus) {
        this.requestID = requestID;
        this.userID = userId;
        this.requestTimeStamp = requestTimeStamp;
        this.neededTimeStamp = neededTimeStamp;
        this.partsRequests = partsRequests;
        this.requestStatus = requestStatus;
    }
}
