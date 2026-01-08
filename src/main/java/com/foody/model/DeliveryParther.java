package com.foody.model;

public class DeliveryParther {
    private String partnerId;
    private String name;
    private String vehicleType;

    public DeliveryParther(String partnerId, String name, String vehicleType) {
        this.partnerId = partnerId;
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public DeliveryParther() {

    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
