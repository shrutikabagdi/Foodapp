package com.foody.model;

import org.springframework.stereotype.Component;

@Component
public class Inventory {
    private int itemId;
    private String itemName;
    private int stock;
    private String description;
    private String imageUrl;

    public Inventory() {}

    public Inventory(int itemId, int stock, String itemName, String description, String imageUrl) {
        this.itemId = itemId;
        this.stock = stock;
        this.itemName = itemName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
