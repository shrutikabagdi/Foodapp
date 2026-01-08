package com.foody.controller;

import com.foody.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    public void placeOrder() {
        System.out.println("Order placed successfully");
        orderService.processOrder();
    }
}
