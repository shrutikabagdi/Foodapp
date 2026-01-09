package com.foody.model;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private String orderId;
    private String invoiceNumber;
    private String userId;
    private String restaurantId;
    private String items;
    private double amount;
    private String date;
    private int quantity;
    private String status; // CREATED, ACCEPTED, PREPARING, PREPARED, OUT_FOR_DELIVERY, DELIVERED

    public Order() {}

    public Order(String orderId, String invoiceNumber, String userId, String restaurantId, String items, double amount, String date, int quantity, String status) {
        this.orderId = orderId;
        this.invoiceNumber = invoiceNumber;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.items = items;
        this.amount = amount;
        this.date = date;
        this.quantity = quantity;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
