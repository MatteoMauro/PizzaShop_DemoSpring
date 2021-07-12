package com.matteo.demo.repository;

import com.matteo.demo.model.Order;

public interface OrderRepository {
    Order save(Order order);
}