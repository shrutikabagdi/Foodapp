package com.foody.model;

import org.springframework.stereotype.Component;

@Component
public class Delivery {
    private String delId;
    private String orderId;
    private String createdOn;
    private String status;
    private String delPartnerId;
    private String toAddress;
    private String fromAddress;
    private double distance;

    public Delivery() {}

    public Delivery(String delId, String orderId, String createdOn, String status, String delPartnerId, String toAddress, String fromAddress, double distance) {
        this.delId = delId;
        this.orderId = orderId;
        this.createdOn = createdOn;
        this.status = status;
        this.delPartnerId = delPartnerId;
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.distance = distance;
    }

    public String getDelId() {
        return delId;
    }

    public void setDelId(String delId) {
        this.delId = delId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelPartnerId() {
        return delPartnerId;
    }

    public void setDelPartnerId(String delPartnerId) {
        this.delPartnerId = delPartnerId;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}