package com.partscrib.partscribmanagementsystem.model;

public class PartRequestModel {

    enum STATUS {
        READY_FOR_PICKUP,
        OUTSTANDING,
        RETURNED
    }



    private String requestID, partID, quantity, returnStatus;

    public PartRequestModel(String requestID, String partID, String quantity, String returnStatus) {
        this.requestID = requestID;
        this.partID = partID;
        this.quantity = quantity;
        this.returnStatus = returnStatus;
    }



    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getPartID() {
        return partID;
    }

    public void setPartID(String partID) {
        this.partID = partID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }




}
