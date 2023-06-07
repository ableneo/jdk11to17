package com.ableneo.jdk11to17.ex02instanceof;

public class Cat extends Animal implements Meowable {

    protected Cat(FurColor furColor) {
        super(furColor);
    }

    @Override
    public void meow() {
        System.out.println("Meow!");
    }
}
