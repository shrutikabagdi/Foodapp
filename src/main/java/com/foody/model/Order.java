package com.foody.model;

public class Order {
    private String orderId;
    private String customerName;
    private String foodItems;

    public Order(String orderId, String customerName, String foodItems) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItems = foodItems;
    }
    public Order() {

    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }
}
