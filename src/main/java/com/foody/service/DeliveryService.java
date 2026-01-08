package com.foody.service;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    public void deliverOrder() {
        System.out.println("Order is out for delivery");
    }
}
