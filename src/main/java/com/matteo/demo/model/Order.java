package com.matteo.demo.model;

import com.matteo.demo.model.security.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Name is required")
    private String deliveryName;

    //    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    //    @NotBlank(message = "City is required")
    private String deliveryCity;

    //    @NotBlank(message = "State is required")
    private String deliveryState;

    //    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    //    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    //    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    //    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @ManyToOne
    private User user;

    @Transient
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}
