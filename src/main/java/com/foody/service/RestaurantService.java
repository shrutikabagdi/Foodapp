package com.foody.service;

import org.springframework.stereotype.Service;

@Service

public class RestaurantService {
    public void prepareFood() {
        System.out.println("Food is being prepared");
    }
}
