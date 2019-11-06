package com.partscrib.partscribmanagementsystem.model;

import java.util.ArrayList;

public class RequestModel {


    private String requestID;

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

    private String neededTimeStamp;
    private ArrayList<String> partsRequests; //List of partsRequestsID

    public RequestModel(String requestID, String neededTimeStamp, ArrayList<String> partsRequests) {
        this.requestID = requestID;
        this.neededTimeStamp = neededTimeStamp;
        this.partsRequests = partsRequests;
    }
}
