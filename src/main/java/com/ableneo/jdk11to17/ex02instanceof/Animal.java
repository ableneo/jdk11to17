package com.ableneo.jdk11to17.ex02instanceof;

public abstract class Animal {

    private final FurColor furColor;

    protected Animal(FurColor furColor) {
        this.furColor = furColor;
    }

    public FurColor getFurColor() {
        return furColor;
    }
}
