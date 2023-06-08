package com.ableneo.jdk11to17.ex06streamapi;

import java.util.ArrayList;
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

    public List<String> mergeOrderProductsHavingLargestQuantity(List<OrderProduct> orderProducts1, List<OrderProduct> orderProducts2) {
        if (orderProducts1.size() != orderProducts2.size()) {
            throw new IllegalArgumentException("Collections must have equal size.");
        }
        final int size = orderProducts1.size();
        final ArrayList<String> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final OrderProduct orderProduct1 = orderProducts1.get(i);
            final OrderProduct orderProduct2 = orderProducts2.get(i);
            if (orderProduct1.getQuantity() > orderProduct2.getQuantity()) {
                result.add(orderProduct1.getSku());
            } else if (orderProduct2.getQuantity() > orderProduct1.getQuantity()) {
                result.add(orderProduct2.getSku());
            }
        }
        return result;
    }
}
