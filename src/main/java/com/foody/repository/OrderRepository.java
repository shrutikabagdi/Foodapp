package com.foody.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public void saveOrder() {
        System.out.println("Order saved in repository");
    }
}
