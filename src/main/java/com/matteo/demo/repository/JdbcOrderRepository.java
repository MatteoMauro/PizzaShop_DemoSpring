package com.matteo.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matteo.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderPizzaInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order")
                .usingGeneratedKeyColumns("id");
        this.orderPizzaInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order_Pizzas");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        return null;
    }
}