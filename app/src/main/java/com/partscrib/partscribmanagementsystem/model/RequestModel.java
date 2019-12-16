package com.partscrib.partscribmanagementsystem.model;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class RequestModel implements Serializable {


    private String requestID; // Generate this random 5 digit number
    private String timeLength; //When is it needed
    private String requestTimeStamp; // How long it will be borrowed
    private String requestStatus;
    private String pinCode;
    private String numItems;
    private List<PartRequestModel> parts;

    public RequestModel(){

    }
    public RequestModel(String requestID, String numItems, String timeLength, String requestTimeStamp, String requestStatus,
                        List<PartRequestModel> parts,
                        String pinCode) {
        this.requestID = requestID;
        this.timeLength = timeLength;
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


    public String gettimeLength() {
        return timeLength;
    }

    public void settimeLength(String timeLength) {
        this.timeLength = timeLength;
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

    public List<PartRequestModel> getParts() {
        return parts;
    }

    public void setParts(List<PartRequestModel> parts) {
        this.parts = parts;
    }




}
