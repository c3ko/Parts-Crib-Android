package com.partscrib.partscribmanagementsystem.model;


import java.util.Map;

public class RequestModel {


    private String requestID; // Generate this random 5 digit number
    private String neededTimeStamp; //When is it needed
    private String requestTimeStamp; // How long it will be borrowed
    private String requestStatus;
    private String pinCode;
    private String numItems;
    private Map<String, PartRequestModel> parts;

    public RequestModel(String requestID, String numItems, String neededTimeStamp, String requestTimeStamp, String requestStatus,
                        Map<String, PartRequestModel> parts,
                        String pinCode) {
        this.requestID = requestID;
        this.neededTimeStamp = neededTimeStamp;
        this.requestTimeStamp = requestTimeStamp;
        this.requestStatus = requestStatus;
        this.parts = parts;
        this.numItems = numItems;
        this.pinCode = pinCode;

    }

    public String getNumItems(){
        return numItems;
    }

    public String setNumItems(){
        return numItems;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    public Map<String, PartRequestModel> getParts() {
        return parts;
    }

    public void setParts(Map<String, PartRequestModel> parts) {
        this.parts = parts;
    }




}
