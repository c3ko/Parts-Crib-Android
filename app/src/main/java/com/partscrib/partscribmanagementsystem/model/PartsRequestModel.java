package com.partscrib.partscribmanagementsystem.model;

public class PartsRequestModel {

    private String partsReqId;
    private String partId;
    private String quantity;
    private String returnStatus;

    public PartsRequestModel(String partsReqId, String partId, String quantity, String returnStatus) {
        this.partsReqId = partsReqId;
        this.partId = partId;
        this.quantity = quantity;
        this.returnStatus = returnStatus;
    }

    public String getPartsReqId() {
        return partsReqId;
    }

    public void setPartsReqId(String partsReqId) {
        this.partsReqId = partsReqId;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
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
