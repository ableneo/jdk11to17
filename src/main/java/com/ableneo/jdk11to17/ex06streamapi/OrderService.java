package com.ableneo.jdk11to17.ex06streamapi;

import java.util.Collection;
import java.util.List;

public class OrderService {

    public List<String> getProductSkusForCustomerHavingQuantityMoreThan(Collection<Order> orders,
                                                                        Customer customer,
                                                                        int quantity) {
        return orders
                .stream()
                .filter(order -> order.getCustomer().equals(customer))
                .<String>mapMulti((order, consumer) -> {
                    for (OrderProduct orderProduct : order.getOrderProducts()) {
                        // here we could generate as many items, as we wanted. Or none at all.
                        // It doesn't have to be 1:1 mapping
                        if (orderProduct.getQuantity() > quantity) {
                            consumer.accept(orderProduct.getSku());
                        }
                    }
                })
                .toList();
    }
}
