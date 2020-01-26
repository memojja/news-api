package com.newsapi.bundle.model.dto;

public enum DeliverStatus {

    COMPLETED("TESLIM EDILDI"),NOT_COMPLETED("TESLIM EDILMEDI");

    private String status;

    DeliverStatus(String status){
        this.status = status;
    }

    public String value(){
        return status;
    }

}
