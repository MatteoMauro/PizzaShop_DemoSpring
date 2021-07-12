package com.matteo.demo.repository;

import com.matteo.demo.model.Pizza;

public interface PizzaRepository {
    Pizza save(Pizza design);
}