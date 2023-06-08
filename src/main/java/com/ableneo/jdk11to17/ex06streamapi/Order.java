package com.ableneo.jdk11to17.ex06streamapi;

import java.util.List;

public class Order {
    private final Customer customer;
    private final List<OrderProduct> orderProducts;

    public Order(Customer customer, List<OrderProduct> orderProducts) {
        this.customer = customer;
        this.orderProducts = orderProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }
}
