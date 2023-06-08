package com.ableneo.jdk11to17.ex06streamapi;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    public List<String> getProductSkusForCustomerHavingQuantityMoreThan(Collection<Order> orders,
                                                                        Customer customer,
                                                                        int quantity) {

        return orders
                .stream()
                .filter(order -> order.getCustomer().equals(customer))
                .flatMap(order -> order.getOrderProducts().stream())
                .filter(orderProduct -> orderProduct.getQuantity() > quantity)
                .map(OrderProduct::getSku)
                .collect(Collectors.toList());
    }
}
