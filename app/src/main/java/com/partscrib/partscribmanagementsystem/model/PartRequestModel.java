package com.partscrib.partscribmanagementsystem.model;

import java.io.Serializable;

public class PartRequestModel implements Serializable {

    enum STATUS {
        READY_FOR_PICKUP,
        OUTSTANDING,
        RETURNED
    }



    private String name, quantity;

    public PartRequestModel(){

    }
    public PartRequestModel(String name, String quantity) {

        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }





}
