package com.foody.model;

public class Restaurant {
    private String restaurantId;
    private String name;
    private String cuisine;

    public Restaurant(String restaurantId, String cuisine, String name) {
        this.restaurantId = restaurantId;
        this.cuisine = cuisine;
        this.name = name;
    }
    public Restaurant() {

    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
