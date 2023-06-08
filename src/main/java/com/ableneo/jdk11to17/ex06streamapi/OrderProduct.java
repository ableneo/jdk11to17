package com.ableneo.jdk11to17.ex06streamapi;

public class OrderProduct {
    private final String sku;
    private final int quantity;

    public OrderProduct(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}
