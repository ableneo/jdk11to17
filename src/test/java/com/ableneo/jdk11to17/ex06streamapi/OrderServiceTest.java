package com.ableneo.jdk11to17.ex06streamapi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    private final String SKU_1 = "sku1";
    private final String SKU_2 = "sku2";
    private final String SKU_3 = "sku3";
    private final String SKU_4 = "sku4";

    private final Customer JOHN_DOE = new Customer("John", "Doe");
    private final Customer SNOW_WHITE = new Customer("Snow", "White");

    private final OrderService orderService = new OrderService();

    @Test
    void returnsCorrectSkusForJohnDoe() {
        final Order johnDoeOrder = new Order(JOHN_DOE, List.of(
                new OrderProduct(SKU_1, 1),
                new OrderProduct(SKU_2, 20)
        ));
        final Order snowWhiteOrder = new Order(SNOW_WHITE, List.of(
                new OrderProduct(SKU_3, 1),
                new OrderProduct(SKU_4, 20)
        ));
        final List<Order> orders = List.of(johnDoeOrder, snowWhiteOrder);

        final List<String> skus = orderService.getProductSkusForCustomerHavingQuantityMoreThan(orders, JOHN_DOE, 10);

        assertThat(skus).containsExactly(SKU_2);
    }

    @Test
    void returnsCorrectSkusForSnowWhite() {
        final Order johnDoeOrder = new Order(JOHN_DOE, List.of(
                new OrderProduct(SKU_1, 1),
                new OrderProduct(SKU_2, 20)
        ));
        final Order snowWhiteOrder = new Order(SNOW_WHITE, List.of(
                new OrderProduct(SKU_3, 1),
                new OrderProduct(SKU_4, 20)
        ));
        final List<Order> orders = List.of(johnDoeOrder, snowWhiteOrder);

        final List<String> skus = orderService.getProductSkusForCustomerHavingQuantityMoreThan(orders, SNOW_WHITE, 10);

        assertThat(skus).containsExactly(SKU_4);
    }

}