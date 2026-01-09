package com.foody.model;

import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    private int resTd;
    private String name;
    private double latitude;
    private double longitude;
    private double deliveryRadius;
    private String address;
    private double ratings;

    public Restaurant() {}

    public Restaurant(String resTd, String name, double latitude, double longitude, double deliveryRadius, String address, double ratings) {
        this.resTd = resTd;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.deliveryRadius = deliveryRadius;
        this.address = address;
        this.ratings = ratings;
    }

    public String getResTd() {
        return resTd;
    }

    public void setResTd(String resTd) {
        this.resTd = resTd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDeliveryRadius() {
        return deliveryRadius;
    }

    public void setDeliveryRadius(double deliveryRadius) {
        this.deliveryRadius = deliveryRadius;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
}